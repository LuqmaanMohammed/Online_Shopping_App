package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signup.ui.DatabaseHelper;
import com.example.signup.ui.InputValidation;
import com.example.signup.ui.User;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

TextInputLayout name_lay,email_lay,pass_lay,conf_lay;
EditText name_reg,email_reg,pass_reg,conf_reg;
Button register;
TextView already_ac;

private DatabaseHelper databaseHelper;
private InputValidation inputValidation;
User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name_lay = findViewById(R.id.textInputName);
        email_lay = findViewById(R.id.textInputEmail);
        pass_lay = findViewById(R.id.textInputPassword);
        conf_lay = findViewById(R.id.textInputConfirmPassword);


        name_reg = findViewById(R.id.editTextName);
        email_reg = findViewById(R.id.editTextEmail);
        pass_reg = findViewById(R.id.editTextPassword);
        conf_reg = findViewById(R.id.editTextConfirmPassword);


        register= findViewById(R.id.buttonRegister);
        already_ac = findViewById(R.id.loginTxt);

         databaseHelper =  new DatabaseHelper(this);
        inputValidation = new InputValidation(this);
        user = new User();
        
        
        register.setOnClickListener(v -> {
            if(!inputValidation.isInputEditTextFilled(name_reg,name_lay,"Enter your Name"))
            {
                return;
            }
            if(!inputValidation.isInputEditTextFilled(email_reg,email_lay,"Enter your Email"))
            {
                return;
            }if(!inputValidation.isInputEditTextEmail(email_reg,email_lay,"Enter valid Email"))
            {
                return;
            }
            if(!inputValidation.isInputEditTextFilled(pass_reg,pass_lay,"Enter your password"))
            {
                return;
            }if(!inputValidation.isInputEditTextMatches(pass_reg,conf_reg,conf_lay,"Passwords don't match"))
            {
                return;
            }
            if(!databaseHelper.checkUserEmail(email_reg.getText().toString().trim()))
            {
                user.setName(name_reg.getText().toString().trim());
                user.setEmail(email_reg.getText().toString().trim());
                user.setPassword(pass_reg.getText().toString().trim());
                databaseHelper.addUser(user);


                //Toast to show success message that record is saved

                Toast.makeText(SignUpActivity.this,"Registration Successful",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SignUpActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(SignUpActivity.this,"Email Already Exists",Toast.LENGTH_LONG).show();
            }

        });

        already_ac.setOnClickListener(v->
        {
            Intent intent = new Intent(SignUpActivity.this,Login.class);
            startActivity(intent);
            finish();
        });

    }
}