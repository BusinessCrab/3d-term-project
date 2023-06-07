package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity
{
    private EditText login, password, repassword;
    private Button signupButton;
    private DBHelper DB;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login = (EditText) findViewById(R.id.login_edittext);
        password = (EditText) findViewById(R.id.password_edittext);
        repassword = (EditText) findViewById(R.id.repassword_edittext);
        signupButton = (Button) findViewById(R.id.signup_button);
        DB = new DBHelper(this);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = login.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(log.equals("")||pass.equals("")|| repass.equals(""))
                    Toast.makeText(SignUpActivity.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                else{
                    if (pass.equals(repass))
                    {
                        Boolean checkLogin = DB.checkUsername(log);
                        if (checkLogin == false)
                        {
                            Boolean insert = DB.insertData(log, pass);
                            if (insert==true) {
                                Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(v.getContext(), LogInActivity.class));
                                finish();
                            }
                            else
                                Toast.makeText(SignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(SignUpActivity.this, "This user already exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(SignUpActivity.this, "Passwords confirmation failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
