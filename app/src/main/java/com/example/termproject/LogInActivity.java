package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity{
    private EditText login, password;
    private Button loginButton, signupButton;
    private DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.login_edittext);
        password = (EditText) findViewById(R.id.password_edittext);
        loginButton=(Button) findViewById(R.id.login_button);
        signupButton=(Button) findViewById(R.id.signup_button);
        DB = new DBHelper(this);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), SignUpActivity.class));
                finish();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = login.getText().toString();
                String pass = password.getText().toString();

                if (log.equals("")||pass.equals(""))
                    Toast.makeText(LogInActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                     Boolean checkUsernamePassword = DB.checkUsernamePassword(log, pass);
                     if (checkUsernamePassword == true) {
                         Toast.makeText(LogInActivity.this, "Log in successful", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(v.getContext(), MainActivity.class));
                         finish();
                     }
                     else
                         Toast.makeText(LogInActivity.this, "Log in failed! Check your login and password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}