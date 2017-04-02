package com.example.administrator.sqlitehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;
import static android.R.attr.name;

/**
 * Created by Administrator on 3/23/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "PersonsDB";
    public static final String TABLE_NAME = "Persons";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME ="name";
    public static final String COLUMN_ADD = "address";



    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " +TABLE_NAME
                +"(" +COLUMN_ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +COLUMN_NAME+
                " VARCHAR, " +COLUMN_ADD+
                " VARCHAR);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Persons";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public boolean addPerson(String name, String add){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_ADD, add);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }
    public Cursor getPerson(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM Persons WHERE id="+id+";";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}
