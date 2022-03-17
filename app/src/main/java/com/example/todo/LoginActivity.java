package com.example.todo;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        set the theme to default to dark mode
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        startTaskActivity();

    }

    public void startTaskActivity() {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
        finish();
    }

}