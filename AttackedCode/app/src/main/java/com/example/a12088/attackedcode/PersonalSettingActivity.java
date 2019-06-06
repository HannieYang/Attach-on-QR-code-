package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalSettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_setting);
        //----find both the button---
        Button buttonExit = (Button) findViewById(R.id.button_exit_from_personal);
        Button buttonName = (Button) findViewById(R.id.button_set_name);
        Button buttonPassword = (Button) findViewById(R.id.button_set_password);
        Button buttonLogin = (Button) findViewById(R.id.button_login);
        //----register click event with buttonExit------
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(PersonalSettingActivity.this, MoreActivity.class);
                /*调用MoreActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonName------
        buttonName.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent2 = new Intent();
                intent2.setClass(PersonalSettingActivity.this, SetNameActivity.class);
                /*调用SetNameActivity*/
                startActivityForResult(intent2, 0);
            }
        });
        //----register click event with buttonPassword------
        buttonPassword.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent3 = new Intent();
                intent3.setClass(PersonalSettingActivity.this, SetPasswordActivity.class);
                /*调用SetPasswordActivity*/
                startActivityForResult(intent3, 0);
            }
        });
        //----register click event with buttonPassword------
        buttonLogin.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent4 = new Intent();
                intent4.setClass(PersonalSettingActivity.this, LoginActivity.class);
                /*调用LoginActivity*/
                startActivityForResult(intent4, 0);
            }
        });
    }
}
