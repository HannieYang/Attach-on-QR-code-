package com.example.a12088.attackedcode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.xys.libzxing.zxing.encoding.EncodingUtils;

public class MakeCodeActivity extends Activity {
    private EditText inputLink;
    private ImageView mResult;
    private CheckBox mLogo;
    private Button buttonExit;
    private Button buttonPreview;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_code);

        //--------找到所有按钮------------
        buttonExit = (Button) findViewById(R.id.button_exit_from_make);
        buttonPreview = (Button) findViewById(R.id.button_preview);
        buttonSave = (Button) findViewById(R.id.button_save);
        inputLink = (EditText) findViewById(R.id.text_link);
        mResult = (ImageView) findViewById(R.id.view_made_code);
        mLogo = (CheckBox) findViewById(R.id.choose_if_logo);
        //----register click event with buttonExit------
        buttonExit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(MakeCodeActivity.this, MainActivity.class);
                /*调用MainActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonPreview------
        buttonPreview.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                make();
            }
        });
    }
    public void make(){

        String input =inputLink.getText().toString();

        if(input.equals("")){

            Toast.makeText(MakeCodeActivity.this,"输入不能为空",Toast.LENGTH_LONG).show();

        }else {

            Bitmap bitmap= EncodingUtils.createQRCode(input,500,500,

                    mLogo.isChecked()?

                            BitmapFactory.decodeResource(getResources(),R.drawable.tubiao):null);

            mResult.setImageBitmap(bitmap);

        }

    }
}
