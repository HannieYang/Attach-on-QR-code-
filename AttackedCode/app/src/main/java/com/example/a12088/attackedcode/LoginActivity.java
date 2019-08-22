package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private UserDBHelper dbHelper;
    private EditText username;
    private EditText userpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new UserDBHelper(this,"UserStore.db",null,1);
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
                username = (EditText)findViewById(R.id.text_user_id);
                userpassword = (EditText)findViewById(R.id.text_user_password);
                String userName = username.getText().toString();
                String passWord = userpassword.getText().toString();
                if (login(userName,passWord)) {
                    Toast.makeText(LoginActivity.this, "登陆成功（ZY，111）", Toast.LENGTH_SHORT).show();
                    /*new an Intent object, and figure out class*/
                    Intent intent2 = new Intent();
                    intent2.setClass(LoginActivity.this, PersonalSettingActivity.class);
                /*调用PersonalSettingActivity*/
                    startActivityForResult(intent2, 0);
                }
                else {
                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
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
    public boolean login(String username,String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from userData where name=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {username, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }
}
