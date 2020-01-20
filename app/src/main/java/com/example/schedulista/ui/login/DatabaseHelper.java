package com.example.schedulista.ui.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "schedulista.db";
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "USER_ID";
    public static final String COL_2 = "FullName";
    public static final String COL_3 = "Email";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "City";
    public static final String COL_6 = "Gender";
    public static final String COL_7 = "Contact";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE "+TABLE_NAME+" (USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,FullName text,Email text, Password text, City text,Gender text, Contact number )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }

    public boolean insertData(String fullname, String email,String password, String city, String gender, String contact )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,fullname);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,password);
        contentValues.put(COL_5,city);
        contentValues.put(COL_6,gender);
        contentValues.put(COL_7,contact);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
