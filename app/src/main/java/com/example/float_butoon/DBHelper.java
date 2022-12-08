package com.example.float_butoon;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;

//    private static final String DATABASE_NAME = ("SaveBook.db");
    private static final String DATABASE_NAME = ("SaveBook.db");
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME =("tblbook");
    private static final String COLUMN_ID = ("id");
    private static final String COLUMN_TITLE = ("book_title");
    private static final String COLUMN_ATHOR = ("book_author");
    private static final String COLUMN_PAGE = ("book_pages");
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public DBHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                " CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + "INTEGER primary key autoincrement,"+
                COLUMN_TITLE + "TEXT," +
                COLUMN_ATHOR + "TEXT,"+
                COLUMN_PAGE + "INTEGER );";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    void addbook (String title, String author, int pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE,title);
        contentValues.put(COLUMN_ATHOR,author);
        contentValues.put(COLUMN_PAGE,pages);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1) {
            Toast.makeText(context, "Record is inserted",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(context,"Record is not inserted",Toast.LENGTH_LONG).show();
        }
    }

    Cursor readAllData(){
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }
}
