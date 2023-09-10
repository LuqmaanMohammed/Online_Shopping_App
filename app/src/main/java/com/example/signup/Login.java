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

public class Login extends AppCompatActivity {

    TextInputLayout email_lay,pass_lay;
    EditText email_reg,pass_reg;
    Button login;
    TextView new_user;
    public static String userEmail;
    public static String userName;

    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        email_lay = findViewById(R.id.textInputEmailLogin);
        pass_lay = findViewById(R.id.textInputPasswordLogin);


        email_reg = findViewById(R.id.editTextEmailLogin);
        pass_reg = findViewById(R.id.editTextPasswordLogin);


        login= findViewById(R.id.buttonLogin);
        new_user = findViewById(R.id.signupTxt);

        databaseHelper =  new DatabaseHelper(this);
        inputValidation = new InputValidation(this);
        user = new User();


        login.setOnClickListener(v -> {

            userEmail = email_reg.getText().toString().trim();
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
            }
            if(!databaseHelper.checkUserEmail(userEmail))
            {

                Toast.makeText(Login.this,"Email not found ",Toast.LENGTH_LONG).show();
            }
            else if(!databaseHelper.checkUserPassword(email_reg.getText().toString().trim(),pass_reg.getText().toString().trim()))
            {
                Toast.makeText(Login.this,"Wrong Password ",Toast.LENGTH_LONG).show();
            }
            else
            {
                //Toast to show success message that login successful

                Toast.makeText(Login.this,"login Successful",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Login.this,MainNavigationDrawer.class);
                startActivity(intent);
                finish();
            }

        });

        new_user.setOnClickListener(v->
        {
            Intent intent = new Intent(Login.this,SignUpActivity.class);
            startActivity(intent);
            finish();
        });

    }
}