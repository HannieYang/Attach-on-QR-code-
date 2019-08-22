package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    private UserDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new UserDBHelper(this,"UserStore.db",null,1);
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
                //SQLiteDatabase db=dbHelper.getWritableDatabase();

                EditText newname=(EditText)findViewById(R.id.text_new_user_name);
                EditText newpassword=(EditText)findViewById(R.id.text_new_user_password);
                EditText password=(EditText)findViewById(R.id.re_text_new_user_password);
                String newName =newname.getText().toString();
                String newPassword=newpassword.getText().toString();
                String Password = password.getText().toString();
                if(Password.compareTo(newPassword) != 0){
                    Toast.makeText(RegisterActivity.this,"两次输入密码不同，注册失败",Toast.LENGTH_SHORT).show();
                }else {
                    if (CheckIsDataAlreadyInDBorNot(newName)) {
                        Toast.makeText(RegisterActivity.this, "该用户名已被注册，注册失败", Toast.LENGTH_SHORT).show();
                    } else {
                        if (register(newName, newPassword)) {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            /*new an Intent object, and figure out class*/
                            Intent intent2 = new Intent();
                            intent2.setClass(RegisterActivity.this, LoginActivity.class);
                            /*调用 LoginActivity*/
                            startActivityForResult(intent2, 0);
                        }
                    }
                }

            }
        });
    }
    //向数据库插入数据
    public boolean register(String username,String password){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        /*String sql = "insert into userData(name,password) value(?,?)";
        Object obj[]={username,password};
        db.execSQL(sql,obj);*/
        ContentValues values=new ContentValues();
        values.put("name",username);
        values.put("password",password);
        db.insert("userData",null,values);
        db.close();
        //db.execSQL("insert into userData (name,password) values (?,?)",new String[]{username,password});
        return true;
    }
    //检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String Query = "Select * from userData where name =?";
        Cursor cursor = db.rawQuery(Query,new String[] { value });
        if (cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        cursor.close();
        return false;
    }

}
