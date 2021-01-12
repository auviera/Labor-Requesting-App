package com.example.laborrequestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class workerLogin extends AppCompatActivity {

    EditText email,password;
    Button button_signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_login);

        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password1);
        button_signin = (Button) findViewById(R.id.button_signin1);
        DB = new DBHelper(this);

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(workerLogin.this, "Please enter all the field", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkemailpassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(workerLogin.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),wrokerHome.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(workerLogin.this, "wrong username/password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}