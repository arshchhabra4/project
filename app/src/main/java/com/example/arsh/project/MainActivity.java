package com.example.arsh.project;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewPager();

        /*Making status bar light*/
        changeStatusBarColor();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    private void setViewPager() {
        int[] layouts={R.layout.activity_shop, R.layout.activity_cart, R.layout.activity_profile};
        ViewPager mainViewPager=(ViewPager)findViewById(R.id.vewpager_main);
        MyPagerAdapter adapter= new MyPagerAdapter(MainActivity.this, layouts);
        mainViewPager.setAdapter(adapter);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tab_main);
        tabLayout.setupWithViewPager(mainViewPager);

        /*Set Icons to Tabs*/
         int[] imageResId = {
                R.drawable.shop,
                R.drawable.cart,
                R.drawable.profile};

        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }

    }
}
