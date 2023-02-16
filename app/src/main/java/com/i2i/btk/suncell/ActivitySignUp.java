package com.i2i.btk.suncell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ActivitySignUp extends AppCompatActivity {
    EditText editTextName,editTextSurName,editTextEmail,editTextPhoneNumber,editTextPassword,editTextSecurityAnswer;
    Spinner spinnerQuestions;
    ArrayAdapter<String> arrayAdapterQuestions;
    ConstraintLayout constraintLayoutSignUp;
    String[] questions = {"SELECT A QUESTION","YOUR PET'S NAME?", "YOUR FAVORITE SONG?", "YOUR FATHER'S NAME?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fullScreen();
        initComponents();
        setOnClick();
    }

    private void initComponents(){
        editTextName=findViewById(R.id.editTextName);
        editTextSurName=findViewById(R.id.editTextSurName);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPasswordLogin);
        editTextPhoneNumber=findViewById(R.id.editTextPhoneNumberLogin);
        editTextSecurityAnswer=findViewById(R.id.editTextSecurityAnswer);
        constraintLayoutSignUp=findViewById(R.id.constraintLayoutSignUp);
        spinnerQuestions=findViewById(R.id.spinnerQuestions);
        arrayAdapterQuestions=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,questions);
        spinnerQuestions.setAdapter(arrayAdapterQuestions);
        arrayAdapterQuestions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuestions.setPrompt("Please select a question.");
        spinnerQuestions.setScrollBarSize(20);
    }
    private void fullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void setOnClick(){
        constraintLayoutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}