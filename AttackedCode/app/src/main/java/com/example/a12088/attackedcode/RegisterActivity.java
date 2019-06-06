package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //---------find all buttons-----------
        Button buttonExit = (Button) findViewById(R.id.button_exit_from_register);
        Button buttonRegister = (Button) findViewById(R.id.button_confirm_register);
        //----register click event with buttonExit------
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(RegisterActivity.this, LoginActivity.class);
                /*调用 LoginActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonSet------
        buttonRegister.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent2 = new Intent();
                intent2.setClass(RegisterActivity.this, LoginActivity.class);
                /*调用 LoginActivity*/
                startActivityForResult(intent2, 0);
            }
        });
    }
}
