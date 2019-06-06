package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetNameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);
        //--------找到所有按钮----------
        Button buttonExit = (Button) findViewById(R.id.button_exit_from_set_name);
        Button buttonSet = (Button) findViewById(R.id.button_confirm_name);
        //----register click event with buttonExit------
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(SetNameActivity.this, PersonalSettingActivity.class);
                /*调用MoreActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonSet------
        buttonSet.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent2 = new Intent();
                intent2.setClass(SetNameActivity.this, PersonalSettingActivity.class);
                /*调用MoreActivity*/
                startActivityForResult(intent2, 0);
            }
        });
    }
}
