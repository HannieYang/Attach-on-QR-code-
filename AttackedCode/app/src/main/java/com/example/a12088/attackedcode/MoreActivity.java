package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        //--------找到所有按钮------------
        Button buttonExit = (Button) findViewById(R.id.button_exit_from_more);
        //Button buttonRecord = (Button) findViewById(R.id.button_record);
        //Button buttonAdvice = (Button) findViewById(R.id.button_advice);
        //Button buttonPolicy = (Button) findViewById(R.id.button_policy);
        Button buttonPersonal = (Button) findViewById(R.id.button_personal);
        Button buttonInformation = (Button) findViewById(R.id.button_information);

        //----register click event with buttonExit------
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(MoreActivity.this, MainActivity.class);
                /*调用MainActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonPersonal------
        buttonPersonal.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent2 = new Intent();
                intent2.setClass(MoreActivity.this, PersonalSettingActivity.class);
                /*调用PersonalSettingActivity*/
                startActivityForResult(intent2, 0);
            }
        });
        //----register click event with buttonInformation------
        buttonInformation.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent3 = new Intent();
                intent3.setClass(MoreActivity.this, MakerInformationActivity.class);
                /*调用MakerInformationActivity*/
                startActivityForResult(intent3, 0);
            }
        });
    }
}
