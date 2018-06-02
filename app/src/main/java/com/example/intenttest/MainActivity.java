package com.example.intenttest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    private void myLog(String tag, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.d(tag, msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLog(TAG, "***** onCreate *****");

        final WebView webview = new WebView(this);

        final String packageName = getPackageName();


        Button bt_toSub = (Button)findViewById(R.id.button_toSub);
        bt_toSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v) {
            }
        });

        bt_toSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName(packageName, packageName + ".SubActivity");
                startActivity(intent);
            }
        });

        EditText et_message = (EditText) findViewById(R.id.editText_message);
        final String message = et_message.getText().toString();

        et_message.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                //EnterKeyが押されたかを判定
                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {

                    //ソフトキーボードを閉じる
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    //検索処理
                    executeSearch(message, packageName);

                }
                return false;
            }
        });

        Button bt_toSub2 = (Button)findViewById(R.id.button_toSub2);
        bt_toSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeSearch(message, packageName);
            }

        });
    }

    private void executeSearch(String message, String packageName) {
        Intent intent = new Intent();
        if (message.length() >= 2) {
            intent.setClassName(packageName, packageName + ".SubActivity");
            intent.putExtra("message", message);
            startActivity(intent);
        } else {
            intent.setClassName(packageName, packageName + ".LoadActivity");
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        myLog(TAG, "***** onActivityResult *****");

        if(resultCode == Activity.RESULT_OK) {
            String errMsg = data.getStringExtra("errMsg");
            Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show();
        }
    }
}
