package com.i2i.btk.suncell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySignIn extends AppCompatActivity {
    EditText editTextPhoneNumber, editTextPassword;
    TextView textViewRegister;
    ConstraintLayout constraintLayoutLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initComponents();
        setOnClicks();
        fullScreen();
    }
    private void initComponents() {
        editTextPassword=findViewById(R.id.editTextPasswordLogin);
        editTextPhoneNumber=findViewById(R.id.editTextPhoneNumberLogin);
        textViewRegister=findViewById(R.id.textViewRegister);
        constraintLayoutLogin=findViewById(R.id.constraintLayoutSignIn);
    }
    private void setOnClicks(){
        constraintLayoutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=editTextPhoneNumber.getText().toString();
                String password=editTextPassword.getText().toString();
                loginSuccess();
            }
        });
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivitySignIn.this,ActivitySignUp .class);
                startActivity(intent);
            }
        });
    }


    private void fullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    private void loginSuccess(){
        Intent intent=new Intent(ActivitySignIn .this,ActivityUserInfo.class);
        startActivity(intent);
    }

}