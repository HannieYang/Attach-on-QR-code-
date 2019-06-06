package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //-----找到所有button--------
        Button buttonMore = (Button) findViewById(R.id.button_more);
        Button buttonScan = (Button) findViewById(R.id.button_scan);
        Button buttonMake = (Button) findViewById(R.id.button_make);

        //----register click event with buttonScan------
        buttonMore.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, MoreActivity.class);
                /*调用MoreActivity*/
                startActivityForResult(intent1, 0);
            }
        });

        //----register click event with buttonScan------
        buttonScan.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, ScanCodeActivity.class);
                /*调用ScanCodeActivity*/
                startActivityForResult(intent2, 0);
            }
        });
        //----register click event with buttonMake------
        buttonMake.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this, MakeCodeActivity.class);
                /*调用MakeCodeActivity*/
                startActivityForResult(intent3, 0);
            }
        });
    }
}
