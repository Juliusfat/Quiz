package com.example.utilisateur.topquiz.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by utilisateur on 10/02/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="contact_database";
    private static final int DATABASE_VERSION = 1;
    private static final String CONTACT_TABLE_SQL = "CREATE TABLE utilisateur("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "first_name TEXT," +
            "score INTEGER )";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACT_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        this.onCreate(db);

    }
}
