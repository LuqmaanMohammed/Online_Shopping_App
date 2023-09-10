package com.example.signup.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NAME = "UserManager.db";
    private  static final String TABLE_USER = "user";
    private  static final String COLUMN_USER_ID = "user_id";
    private  static final String COLUMN_USER_NAME = "user_name";
    private  static final String COLUMN_USER_EMAIL = "user_email";
    private  static final String COLUMN_USER_PASSWORD = "user_password";


    //query to create a table in SQLite (not case sensitive)
    //create table user (user_id, user_name,user_email,user_password);

    //create table sql Query
    private final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT "+ " ) ";


     private final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //SELECT user_id from user WHERE user_email = "xyz";
    public boolean checkUserEmail(String email){
        //array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        //selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";
        //selection Argument
        String[] selectArgs = {email};
        //query user table with condition


        /*Here query function is used to fetch records from user table this function works like we use sql query
        * SELECT user_id FROM user WHERE user_email = "abc@gmail.com";
        */

    Cursor cursor = db.query(TABLE_USER, columns,selection,selectArgs,null,null,null);
    int cursorCount = cursor.getCount();
    cursor.close();
    db.close();
        return cursorCount > 0;
    }
    
    public boolean checkUserPassword(String email,String password){
        //array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        //selection criteria
        String selection = COLUMN_USER_EMAIL + " = ? AND " + COLUMN_USER_PASSWORD + " = ?";
        //selection Argument
        String[] selectArgs = {email,password};
        //query user table with condition


        /*Here query function is used to fetch records from user table this function works like we use sql query
        * SELECT user_id FROM user WHERE user_email = "abc@gmail.com";
        */

    Cursor cursor = db.query(TABLE_USER, columns,selection,selectArgs,null,null,null);
    int cursorCount = cursor.getCount();
    cursor.close();
    db.close();
        return cursorCount > 0;
    }
    
    
    
    
    
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,user.getName());
        values.put(COLUMN_USER_EMAIL,user.getEmail());
        values.put(COLUMN_USER_PASSWORD,user.getPassword());
        //Inserting Row
        db.insert(TABLE_USER,null,values);
        db.close();
    }
//    public void ProvideUser(User user)
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USER, "WHERE ")
//        db.(TABLE_USER,null,values);
//        db.close();
//    }

    public String getUserName(String email){
        //array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        //selection criteria
        String selection = COLUMN_USER_EMAIL + " = ? ";
        //selection Argument
        String[] selectArgs = {email};

        Cursor cursor = db.query(TABLE_USER, columns,selection,selectArgs,null,null,null);
        cursor.moveToFirst();
        String userName = cursor.getString(0);
        cursor.close();
        db.close();
        return userName;
    }

    public void deleteUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER,CREATE_USER_TABLE+ " = ?", new String[]{String.valueOf(user.getId())});
        db.close();
    }
}


