package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class LoadActivity extends AppCompatActivity {

    static final String TAG = "LoadActivity";

    private void myLog(String tag, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.d(tag, msg);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        myLog(TAG, "***** onCreate *****");

        Intent intent = getIntent();
        intent.putExtra("errMsg", "Search Again.");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
