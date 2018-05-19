package com.example.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                intent.setClassName(packageName, packageName + ".SubActivity");

                EditText et_message = (EditText)findViewById(R.id.editText_message);
                String message = et_message.getText().toString();
                intent.putExtra("message", message);

                startActivity(intent);
            }
        });
    }
}
