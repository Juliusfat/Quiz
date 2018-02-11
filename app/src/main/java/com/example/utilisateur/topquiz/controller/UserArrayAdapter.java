package com.example.utilisateur.topquiz.controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.utilisateur.topquiz.R;
import com.example.utilisateur.topquiz.model.user;

import java.util.List;
import java.util.Objects;

/**
 * Created by utilisateur on 11/02/2018.
 */

public class UserArrayAdapter extends ArrayAdapter{

    // initialisation des variables
    private Activity context;
    private List<user> data;
    private int resource;
    private LayoutInflater inflater;



    public UserArrayAdapter(@NonNull Context context, @NonNull List<user> data) {
        super(context,0,data);
        // création du constructeur
        this.data = data;
        this.resource =  resource;
        this.context = (Activity) context;
        this.inflater = this.context.getLayoutInflater();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        // instenciation de la vue
        View view = this.inflater.inflate(R.layout.user_list_view,parent,false);

        user userdata = this.data.get(position);
        // liaison entre les données et la ligne
        TextView firsttextview = view .findViewById((R.id.ListtextViewFirstName));
        firsttextview.setText(userdata.getFirstName());
        TextView scoretextview = view .findViewById((R.id.ListtextViewScore));
        scoretextview.setText(String.valueOf(userdata.getMscore()));


        return view;
    }
}
