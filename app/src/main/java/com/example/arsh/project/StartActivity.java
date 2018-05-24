package com.example.arsh.project;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import me.relex.circleindicator.CircleIndicator;

public class StartActivity extends AppCompatActivity {
    /*Class Variables*/

    private AutoScrollViewPager mViewPager;
    Timer timer;
    Button btn_shop, btn_signup;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /*Find Resources*/
        find();

        /*Set ViewPager*/
        setViewPager();

        /*Making status bar light*/
         changeStatusBarColor();

        /*Button function*/
        activateButtonListener();


    }

    private void activateButtonListener() {

       /* SignUp Button Listener*/
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, SignUp.class);
                startActivity(i);

            }
        });

        /*Shop Button Listener*/
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shop=new Intent(StartActivity.this, MainActivity.class);
                startActivity(shop);
                            }
        });
    }

    private void find() {
        btn_shop=(Button)findViewById(R.id.btn_shop);
        btn_signup=(Button)findViewById(R.id.btn_signup);

    }

    private void setViewPager() {
        int[] layout={R.layout.start_slide1, R.layout.start_slide2, R.layout.start_slide3};
        // Set up the ViewPager with the sections adapter.
        mViewPager = (AutoScrollViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        MyPagerAdapter adapter= new MyPagerAdapter(StartActivity.this, layout);
        mViewPager.setAdapter(adapter);
        indicator.setViewPager(mViewPager);
        mViewPager.setInterval(2000);
        mViewPager.setScrollDurationFactor(1.0);
        mViewPager.startAutoScroll();
    }

    /*Making status bar light*/
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}
