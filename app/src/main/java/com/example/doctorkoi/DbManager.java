package com.example.doctorkoi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {

    private static final String dbname = "Doctor.db";
    public DbManager(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table tbl_docInfo(id integer primary key autoincrement, name text, specialty text, area text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_docInfo");
        onCreate(db);
    }

    public String addRecord(String s1, String s2, String s3){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", s1);
        cv.put("specialty", s2);
        cv.put("area", s3);

        long res = db.insert("tbl_docInfo", null, cv);
        if (res == -1)
            return "Failed";
        else
            return "Successfully inserted";
    }
    public Cursor alldata (){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from tbl_docInfo ", null );
        return cursor;
    }
}
