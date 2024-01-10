package com.example.dictionarykoreann;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAcsses {

    private static DatabaseAcsses  instance;
    private DatabaseOpenHelper openHelper;
    private SQLiteDatabase Database;



    public DatabaseAcsses(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAcsses getInstance (Context context) {
        if (instance == null) {
            instance = new DatabaseAcsses(context);
        }
        return instance;
    }


    public void open()
    {
        this.Database = openHelper.getWritableDatabase();
    }

    Cursor getdata(String name)
    {
        open();
        Cursor cursor = Database.rawQuery("SELECT * FROM data where type = '"+name+"'",  null);
        return cursor;

    }

     public Cursor searchword(String txt){
        open();
         Cursor c =  Database.rawQuery("SELECT * FROM  data where Pronunciation like '%"+txt+"%' or word like '%"+txt+"%'  or means like '%"+txt+"%'",null );
        return c;
    }



}
