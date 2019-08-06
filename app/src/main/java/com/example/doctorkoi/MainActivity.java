package com.example.doctorkoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

     EditText userName, password;
     Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(userName.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(String userName, String password){
        if ((userName.equals("Admin")) && (password.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, Admin_activity.class);
            startActivity(intent);

        }else if ((userName.equals("User")) && (password.equals("12345"))){
            Intent intent = new Intent(MainActivity.this, User_activity.class);
            startActivity(intent);
        }else {
            
        }
    }
}
