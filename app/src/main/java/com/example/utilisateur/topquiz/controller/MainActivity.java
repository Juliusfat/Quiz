package com.example.utilisateur.topquiz.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.utilisateur.topquiz.R;

import com.example.utilisateur.topquiz.model.user;

import java.nio.file.attribute.UserPrincipal;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private user mUser;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences preferences;
    private String firstname;
    private int oldscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = new user();
        preferences  = getPreferences(MODE_PRIVATE);;
        firstname = getPreferences(MODE_PRIVATE).getString("firstname", null);

        //recuperation des variables xml

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);


        helloUser();


        mNameInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    // This is where we'll check the user input
                    mPlayButton.setEnabled(s.toString().length() != 0);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }

            });




        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = mNameInput.getText().toString();
                mUser.setFirstName(firstname);
                // The user just clicked
                SharedPreferences preferences  = getPreferences(MODE_PRIVATE);;
                preferences.edit().putString("firstname", mUser.getFirstName()).apply();
                //on lance l'activité GAME
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);



            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent

            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            preferences.edit().putInt("Score", score).apply();
            helloUser();

        }
    }

    protected void helloUser () {

        if (firstname == null) {
            // bloquer le button
            mPlayButton.setEnabled(false);
            mGreetingText.setText("Hello ! What's your name?");

        } else {
            oldscore = getPreferences(MODE_PRIVATE).getInt("Score", 0);
            mGreetingText.setText("Welcome back, " + firstname + "\n Your lastest score was " + oldscore + ", will you do better this time ?");
            mNameInput.setText(firstname);
            mNameInput.setSelection(firstname.length());
        }


    }

}
