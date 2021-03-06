package com.example.utilisateur.topquiz.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by utilisateur on 10/02/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="user_database";
    private static final int DATABASE_VERSION = 2;
    private static final String USER_TABLE_SQL = "CREATE TABLE user("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "first_name TEXT," +
            "score INTEGER )";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        this.onCreate(db);

    }
}
