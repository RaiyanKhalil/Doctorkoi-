package com.example.doctorkoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_activity extends AppCompatActivity {

    EditText t1, t2, t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activity);

        t1 = (EditText)findViewById(R.id.t1);
        t2 = (EditText)findViewById(R.id.t2);
        t3 = (EditText)findViewById(R.id.t3);

    }

    public void addRecord(View view) {
        DbManager db = new DbManager(this);


        if(( t1.getText().toString().length() == 0 ) ||( t2.getText().toString().length() == 0 ) || ( t3.getText().toString().length() == 0 )){
            t1.setError( "First name is required!" );
            t2.setError( "Specialty name is required!" );
            t3.setError( "Area name is required!" );}
    else {
        String res = db.addRecord(t1.getText().toString(), t2.getText().toString(), t3.getText().toString());
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();}


        t1.setText("");
        t2.setText("");
        t3.setText("");

    }

}
