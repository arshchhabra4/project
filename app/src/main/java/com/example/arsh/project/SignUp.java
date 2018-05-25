package com.example.arsh.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

public class SignUp extends AppCompatActivity {
        EditText inputname,inputemaill,inputpasswordd;
        Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_signup);
        setSupportActionBar(toolbar);
        init();
        list2();

        /*Making status bar light*/
        changeStatusBarColor();

        /*Spannable TExt*/
        spantext();


    }

    private void init() {
        inputname=findViewById(R.id.input_name);
        inputemaill=findViewById(R.id.input_email);
        inputpasswordd=findViewById(R.id.input_password);
        btnsignup=findViewById(R.id.btn_signup);

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

    void spantext(){
        SpannableString ss=new SpannableString("Already a member.Login Here");
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startActivity(new Intent(SignUp.this, SignIn.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 17, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView span=(TextView)findViewById(R.id.sign_up_span_txt);
        span.setText(ss);
        span.setMovementMethod(LinkMovementMethod.getInstance());
    }
    private void list2() {
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputemaill.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(inputname.equals(""))
                {
                    inputname.setError("required field");
                    inputname.requestFocus();
                }

                if (!email.matches(emailPattern)) {

                    inputemaill.setError("not valid");
                    inputemaill.requestFocus();
                    if (email.equals("")) {
                        inputemaill.setError("required field");
                        inputemaill.requestFocus();
                    }
                } else if (inputpasswordd.getText().toString().trim().length() <= 0)

                {

                    inputpasswordd.setError("enter password");
                    inputpasswordd.requestFocus();

                } else {
                    Intent i = new Intent(SignUp.this, SignIn.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }
}
