package com.example.doctorkoi;

import android.database.Cursor;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User_activity extends AppCompatActivity {
    DbManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_activity);
        TextView textView = (TextView) findViewById(R.id.IDspace);
        TextView textView1 = (TextView) findViewById(R.id.namespace);
        TextView textView2 = (TextView) findViewById(R.id.specialtyspace);
        TextView textView3 = (TextView) findViewById(R.id.Areaspace);


        db = new DbManager(this);
        Cursor cursor= db.alldata();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No data in database",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                textView.setText(cursor.getString(0));
                textView1.setText(cursor.getString(1));
                textView2.setText(cursor.getString(2));
                textView3.setText(cursor.getString(3));


            }
        }

    }
}
