package com.example.entrylog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Logentry extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logentry);
        e1=(EditText) findViewById(R.id.name);
        e2=(EditText) findViewById(R.id.admno);
        e3=(EditText) findViewById(R.id.sysno);
        e4=(EditText) findViewById(R.id.dept);
        b1=(AppCompatButton) findViewById(R.id.addbtn);
        b2=(AppCompatButton) findViewById(R.id.logoutbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent i2=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i2);
                    }






        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                    String getName=e1.getText().toString();
                    String getAdm=e2.getText().toString();
                    String getSys=e3.getText().toString();
                    String getDept=e4.getText().toString();

                     Toast.makeText(getApplicationContext(),getName+" "+getAdm+" "+getSys+" "+getDept+" ",Toast.LENGTH_LONG).show();




            }
        });
    }
}