package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //--------find all buttons--------------
        Button buttonExit = (Button) findViewById(R.id.button_exit_from_login);
        Button buttonLogin = (Button) findViewById(R.id.button_confirm_login);
        Button buttonRegister  = (Button) findViewById(R.id.button_register);
        //----register click event with buttonExit------
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(LoginActivity.this, PersonalSettingActivity.class);
                /*调用PersonalSettingActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonName------
        buttonLogin.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent2 = new Intent();
                intent2.setClass(LoginActivity.this, PersonalSettingActivity.class);
                /*调用PersonalSettingActivity*/
                startActivityForResult(intent2, 0);
            }
        });
        //----register click event with buttonPassword------
        buttonRegister.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent3 = new Intent();
                intent3.setClass(LoginActivity.this, RegisterActivity.class);
                /*调用SetPasswordActivity*/
                startActivityForResult(intent3, 0);
            }
        });
    }
}
