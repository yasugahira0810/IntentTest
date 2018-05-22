package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class LoadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        System.out.println("**2**");

        Intent intent = getIntent();
        intent.putExtra("errMsg", "Search Again.");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
