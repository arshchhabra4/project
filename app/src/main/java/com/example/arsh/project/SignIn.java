package com.example.arsh.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
    EditText inputemail,inputpassword;
    Button singin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        /*Spannable TExt*/
            spantext();
            init();

        /*Making status bar light*/
        changeStatusBarColor();

       /* Forgot Password Listener*/
       TextView fgt=(TextView)findViewById(R.id.forgot_paswd_txtv);
       fgt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               /*Create Dialog Here*/
           }
       });

    }

    private void init() {
        inputemail=findViewById(R.id.input_email);
        inputpassword=findViewById(R.id.input_password);
        singin=findViewById(R.id.btn_signin);
    }

    private void spantext() {
        SpannableString ss = new SpannableString("Not a member. SignUp Here");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 14, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView span = (TextView) findViewById(R.id.sign_in_span_txt);
        span.setText(ss);
        span.setMovementMethod(LinkMovementMethod.getInstance());
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
