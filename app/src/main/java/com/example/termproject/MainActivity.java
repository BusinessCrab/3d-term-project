package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private TextView username;
    private Button profileButton;

    @Override
    protected void onCreate(Bundle e)
    {
        super.onCreate(e);
        setContentView(R.layout.activity_main);

        profileButton=findViewById(R.id.profile_button);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ProfileActivity.class));
                finish();
            }
        });
    }
}
