package com.example.a12088.attackedcode;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.util.TypedValue;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.decode.DecodeThread;

public class ScanCodeActivity extends Activity {
    private TextView mTVResult;
    private Button buttonScan;
    private TextView textSafety;
    private Button buttonExit;
    private ImageView mResultImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
        mTVResult=(TextView) findViewById(R.id.text_string_of_code);
        buttonScan = (Button) findViewById(R.id.button_scan_code);
        textSafety = (TextView) findViewById(R.id.text_safety_of_code);
        mResultImage = (ImageView) findViewById(R.id.show_code_picture);
        //------找到所有按钮------
        buttonExit = (Button) findViewById(R.id.button_exit_from_scan);
        //----register click event with buttonMake------
        buttonExit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                /*new an Intent object, and figure out class*/
                Intent intent1 = new Intent();
                intent1.setClass(ScanCodeActivity.this, MainActivity.class);
                /*调用MainActivity*/
                startActivityForResult(intent1, 0);
            }
        });
        //----register click event with buttonMake------
        buttonScan.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if (ContextCompat.checkSelfPermission(ScanCodeActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ScanCodeActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    scan();
                }
            }
        });
    }

    public void scan(){
        startActivityForResult(new Intent(ScanCodeActivity.this, CaptureActivity.class),0);
    }

    @Override

    protected void onActivityResult(int requestCode,int resultCode ,Intent data){

        super.onActivityResult(requestCode,resultCode, data);

        if(resultCode==RESULT_OK){

            Bundle bundle=data.getExtras();
            String result=bundle.getString("result");
            String safe = "safe";
            int width = bundle.getInt("width");
            int height = bundle.getInt("height");
            LayoutParams lps = new LayoutParams(width, height);
            lps.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
            lps.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
            lps.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
            mResultImage.setLayoutParams(lps);
            mTVResult.setText(result);
            textSafety.setText(safe);
            Bitmap barcode = null;
            byte[] compressedBitmap = bundle.getByteArray(DecodeThread.BARCODE_BITMAP);
            if (compressedBitmap != null) {
                barcode = BitmapFactory.decodeByteArray(compressedBitmap, 0, compressedBitmap.length, null);
                // Mutable copy:
                barcode = barcode.copy(Bitmap.Config.RGB_565, true);
            }
            mResultImage.setImageBitmap(barcode);
        }
    }
}
