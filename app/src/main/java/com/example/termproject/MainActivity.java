package com.example.termproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private TextView username;

    @Override
    protected void onCreate(Bundle e)
    {
        super.onCreate(e);
        setContentView(R.layout.activity_main);
    }
}
