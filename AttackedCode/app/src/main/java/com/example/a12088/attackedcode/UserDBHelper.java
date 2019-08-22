package com.example.a12088.attackedcode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 12088 on 2019/8/22.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String CREATE_USERDATA="create table userData(" +
            "id integer primary key autoincrement,"
            +"name text,"
            +"password text)";

    private Context mContext;

    public UserDBHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory,int version){
        super(context,name,cursorFactory,version);
        mContext=context;
    }

    public  void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USERDATA);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        //onCreate(db);
    }


}
