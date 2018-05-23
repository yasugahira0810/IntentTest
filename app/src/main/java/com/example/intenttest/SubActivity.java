package com.example.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    static final String TAG = "SubActivity";

    private void myLog(String tag, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.d(tag, msg);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        myLog(TAG, "***** onCreate *****");

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if(message != null && message.length() > 0) {
            Toast.makeText(SubActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }
}
