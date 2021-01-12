package com.example.laborrequestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class workerSignUp extends AppCompatActivity {

    EditText firstname,lastname,age,gender,email,password,speciality,experience;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_sign_up);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        age = (EditText) findViewById(R.id.age);
        gender = (EditText) findViewById(R.id.gender);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        speciality = (EditText) findViewById(R.id.speciality);
        experience = (EditText) findViewById(R.id.experience);
        signup = (Button) findViewById(R.id.button_sigup);
        signin = (Button) findViewById(R.id.button_signin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();
                String pass = password.getText().toString();
                String fn = firstname.getText().toString();
                String ln = lastname.getText().toString();
                String ages = age.getText().toString();
                String gndr = gender.getText().toString();
                String special = speciality.getText().toString();
                String ex = experience.getText().toString();

                if(user.equals("")||pass.equals("")||fn.equals("")||ln.equals("")||ages.equals("")||gndr.equals("")||special.equals("")||ex.equals(""))
                    Toast.makeText(workerSignUp.this, "Please enter all the field", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkusername(user);
                    if(!checkuser){
                        Boolean insert = DB.insertData(user,pass,fn,ln,ages,gndr,special,ex);
                        if(insert){
                            Toast.makeText(workerSignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),workerLogin.class);
                            startActivity(intent);
                        }else
                            Toast.makeText(workerSignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(workerSignUp.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), workerLogin.class);
                startActivity(intent);

            }
        });

    }
}