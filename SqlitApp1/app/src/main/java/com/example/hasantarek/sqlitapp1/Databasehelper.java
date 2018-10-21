package com.example.hasantarek.sqlitapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hasan Tarek on 6/2/2017.
 */
public class Databasehelper extends SQLiteOpenHelper {
    public static final String database_name = "student.db";
    private final String table_name = "student_table";
    private final String col1 = "ID";
    private final String col2 = "name";
    private final String col3 = "roll";
    private final String col4 = "mark";


    public Databasehelper(Context context) {
        super(context,database_name,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + table_name +
                "(id integer primary key autoincrement,name text,roll integer,mark float)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" + table_name);
    }

    public boolean insertData(String name,String roll,String mark)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentvalue = new ContentValues();
        contentvalue.put(col2,name);
        contentvalue.put(col3,roll);
        contentvalue.put(col4,mark);
       long result = db.insert(table_name,null,contentvalue);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getallData()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + table_name,null);
        return  res;
    }


    public boolean updatedata(String id,String name,String roll,String mark)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentvalue = new ContentValues();
        contentvalue.put(col1,id);
        contentvalue.put(col2,name);
        contentvalue.put(col3,roll);
        contentvalue.put(col4,mark);
        db.update(table_name,contentvalue,"id=?",new String[] {id});
        return true;
    }

    public int deletedata(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name,"id=?",new String[]{id});
    }
}
