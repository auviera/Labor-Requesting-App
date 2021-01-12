package com.example.laborrequestingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class workerProfile extends AppCompatActivity {

    Button profile,ln,age,gender,speciality,experience;
    DBHelper DB;
    TextView show;
    private Object Context;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_profile);
        profile = (Button) findViewById(R.id.profilebttn);
        ln = (Button) findViewById(R.id.lnbttn);
        age = (Button) findViewById(R.id.agebttn);
        gender = (Button) findViewById(R.id.genderbttn);
        speciality = (Button) findViewById(R.id.spbttn);
        experience = (Button) findViewById(R.id.exbttn);
        DB = new DBHelper(this);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.alldata();
                if(res != null && res.getCount()>0){
                    while (res.moveToNext()) {
                        Toast.makeText(workerProfile.this, "Firts name : "+res.getString(2), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(workerProfile.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.alldata();
                if(res != null && res.getCount()>0){
                    while (res.moveToNext()) {
                        Toast.makeText(workerProfile.this, "Last name : "+res.getString(3), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(workerProfile.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.alldata();
                if(res != null && res.getCount()>0){
                    while (res.moveToNext()) {
                        Toast.makeText(workerProfile.this, "Age : "+res.getString(4), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(workerProfile.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.alldata();
                if(res != null && res.getCount()>0){
                    while (res.moveToNext()) {
                        Toast.makeText(workerProfile.this, "Gender : "+res.getString(5), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(workerProfile.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        speciality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.alldata();
                if(res != null && res.getCount()>0){
                    while (res.moveToNext()) {
                        Toast.makeText(workerProfile.this, "Speciality : "+res.getString(6), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(workerProfile.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.alldata();
                if(res != null && res.getCount()>0){
                    while (res.moveToNext()) {
                        Toast.makeText(workerProfile.this, "Experience : "+res.getString(7), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(workerProfile.this, "no data", Toast.LENGTH_SHORT).show();
                }
            }
        });

}}