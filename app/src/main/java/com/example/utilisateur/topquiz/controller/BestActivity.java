package com.example.utilisateur.topquiz.controller;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.utilisateur.topquiz.R;
import com.example.utilisateur.topquiz.model.DatabaseHandler;
import com.example.utilisateur.topquiz.model.user;

import java.util.ArrayList;
import java.util.List;

public class BestActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private ListView userListView;
    private List<user> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best);

        this.db = new DatabaseHandler(this);

        String sql = "SELECT id, first_name, score FROM user";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql,null);

        // boucle sur le curseur

        while (cursor.moveToNext()) {

            userList.add(this.hydrateUser(cursor));
        }

        //fermer cursor

        cursor.close();

        userListView = findViewById(R.id.scoreListView);

        UserArrayAdapter userAdapter = new UserArrayAdapter(this, userList);
        userListView.setAdapter(userAdapter);

    }

    private user hydrateUser(Cursor cursor) {
        user user = new user();
        user.setIdUser(cursor.getLong(0));
        user.setFirstName(cursor.getString(1));
        user.setMscore(cursor.getInt(2));
        return user;
    }
}
