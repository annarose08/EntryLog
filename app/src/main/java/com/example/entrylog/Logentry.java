package com.example.entrylog;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Logentry extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    AppCompatButton b1,b2;
    String url="http://10.0.4.16:3000/api/students";
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
                SharedPreferences preference = getSharedPreferences("logapp", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.clear();
                editor.apply();
                Intent i2=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i2);
            }






        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                //value reading
                    String getName=e1.getText().toString();
                    String getAdm=e2.getText().toString();
                    String getSys=e3.getText().toString();
                    String getDept=e4.getText().toString();
                    //creating JSON object
                JSONObject student=new JSONObject();
                try {
                    student.put("name",getName);
                    student.put("admission_number",getAdm);
                    student.put("system_number",getSys);
                    student.put("department",getDept);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


                //JSON object request creation
                JsonObjectRequest jsonobjectrequest=new JsonObjectRequest(Request.Method.POST,
                        url,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),"Successful", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"Something Went wrong", Toast.LENGTH_LONG).show();

                            }
                        }
                );
                //Request Queue
                RequestQueue requestqueue= Volley.newRequestQueue(getApplicationContext());
                requestqueue.add(jsonobjectrequest);



            }
        });
    }
}