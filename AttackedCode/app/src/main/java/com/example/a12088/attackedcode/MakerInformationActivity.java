package com.example.a12088.attackedcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakerInformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maker_information);
        //-----------设置退出Button-----------
        Button buttonExit = (Button) findViewById(R.id.button_exit_from_maker);
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(MakerInformationActivity.this, MoreActivity.class);
                /*调用MakerInformationActivity*/
                startActivityForResult(intent1, 0);
            }
        });
    }
}
