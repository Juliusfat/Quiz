package com.example.utilisateur.topquiz.model;

/**
 * Created by utilisateur on 06/01/2018.
 */

public class user {

    private String mFirstName;


    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    @Override
    public String toString() {
        return "user{" +
                "mFirstName='" + mFirstName + '\'' +
                '}';
    }
}
