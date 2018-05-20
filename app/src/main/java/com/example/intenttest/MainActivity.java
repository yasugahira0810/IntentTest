package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Button bt_toSub2 = (Button)findViewById(R.id.button_toSub2);
        bt_toSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText et_message = (EditText) findViewById(R.id.editText_message);
                String message = et_message.getText().toString();
                if (message.length() >= 2) {
                    intent.setClassName(packageName, packageName + ".SubActivity");
                    intent.putExtra("message", message);
                    startActivity(intent);
                } else {
                    aintent.setClassName(packageName, packageName + ".LoadActivity");
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("**1**");
        if(resultCode == Activity.RESULT_OK) {
            String errMsg = data.getStringExtra("errMsg");
            Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show();
        }
    }
}
