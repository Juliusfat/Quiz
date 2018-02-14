package com.example.utilisateur.topquiz.controller;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.utilisateur.topquiz.R;
import com.example.utilisateur.topquiz.model.DatabaseHandler;
import com.example.utilisateur.topquiz.model.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private ListView userListView;
    private Button mScoreButton;
    private Button mNameButton;
    private UserArrayAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best);

        this.db = new DatabaseHandler(this);

        userListView = findViewById(R.id.scoreListView);

    }

    private user hydrateUser(Cursor cursor) {
        user user = new user();
        user.setIdUser(cursor.getLong(0));
        user.setFirstName(cursor.getString(1));
        user.setMscore(cursor.getInt(2));
        return user;
    }

    public void sortByFirstName(View view) {

        List<user> userList = new ArrayList<>();
        String sql = "SELECT id, first_name, score FROM user ORDER BY score DESC LIMIT 5";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql,null);

        // boucle sur le curseur

        while (cursor.moveToNext()) {

            userList.add(this.hydrateUser(cursor));
        }

        //fermer cursor

        cursor.close();
        Collections.sort(userList, new Comparator<user>() {
            @Override
            public int compare(user user, user user1) {
                return user.getFirstName().compareTo(user1.getFirstName()) ;
            }
        });

        userAdapter = new UserArrayAdapter(this,userList);
        userListView.setAdapter(userAdapter);

    }

    public void sortByScore(View view) {
        List<user> userList = new ArrayList<>();
        String sql = "SELECT id, first_name, score FROM user ORDER BY score DESC LIMIT 5";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql,null);

        // boucle sur le curseur

        while (cursor.moveToNext()) {

            userList.add(this.hydrateUser(cursor));
        }

        //fermer cursor

        userAdapter = new UserArrayAdapter(this,userList);
        userListView.setAdapter(userAdapter);

    }
    }

