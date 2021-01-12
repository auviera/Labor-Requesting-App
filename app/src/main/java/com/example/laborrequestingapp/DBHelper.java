package com.example.laborrequestingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.UserData;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";
//    public static final String DATABASE_TABLE = "users";
//    public static final String KEY_ROWID = "email";
//    public static final String KEY_PASSWORD = "password";
//    public static final String KEY_FIRSTNAME = "firstname";
//    public static final String KEY_LASTNAME = "lastname";


//    public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_PASSWORD,KEY_FIRSTNAME,KEY_LASTNAME};

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(email TEXT primary key, password TEXT, firstname TEXT, lastname TEXT, age TEXT, gender TEXT, speciality TEXT, experience TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String email, String password, String firstname, String lastname, String age, String gender, String speciality, String experience){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("firstname",firstname);
        contentValues.put("lastname", lastname);
        contentValues.put("age",age);
        contentValues.put("gender",gender);
        contentValues.put("speciality",speciality);
        contentValues.put("experience",experience);


        long result = MyDB.insert("users",null, contentValues);

        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ?", new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ? and password = ?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor alldata(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users",null);
        return cursor;

    }

//    public Cursor getRow(long rowId) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        String where = KEY_ROWID + "=" + rowId;
//        Cursor c =  MyDB.query(true, DATABASE_TABLE, ALL_KEYS,
//                where, null, null, null, null, null);
//        if (c != null) {
//            c.moveToFirst();
//        }
//        return c;
//    }
}
