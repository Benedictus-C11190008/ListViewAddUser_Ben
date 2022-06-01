package com.example.listviewadduser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "UserDataDB";
    private static final String TB_NAME = "Users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_PASS = "password";

    public DBHandler( Context c) {super(c,DB_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TB_NAME+"("+KEY_ID+
                " INTEGER PRIMARY KEY,"+KEY_NAMA+" TEXT,"+
                KEY_PASS+" TEXT"+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS "+TB_NAME);
        onCreate(db);
    }

    public boolean insertUser(DataModel user){
        Log.d("SQLITE", "INSERTING USER");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAMA,user.getNama());
        cv.put(KEY_PASS,user.getPassword());
        db.insert(TB_NAME, null, cv);
        db.close();
        return true;
    }
    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result  = db.rawQuery("SELECT * FROM"+TB_NAME+" WHERE id="+id, null);
        return result;
    }
    public int getDataCount(){
        String query = "SELECT * FROM "+TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        c.close();
        return c.getCount();
    }
    public ArrayList getAll() {
        ArrayList userList = new ArrayList();
        String Query = "SELECT * FROM "+TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(Query, null);


        if (c.moveToFirst()){
            do {
                userList.add("ID: "+c.getString(0)+"\nNAMA: "+c.getString(1)+"\nPASS: "+c.getString(2));
            }while (c.moveToNext());
        }

        return userList;
    }
}
