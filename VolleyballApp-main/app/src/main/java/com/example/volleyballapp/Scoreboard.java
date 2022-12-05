package com.example.volleyballapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.*;
import androidx.fragment.app.Fragment;

public class Scoreboard extends Fragment {

    EditText awayTeamName;
    public Scoreboard(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scoreboard, container, false);


    }


    //    homeScores = getView().findViewById(R.id.homeScore);
      // double num = Double.parseDouble((homeScores.getText().toString())) + 1;
       // homeScores.setText("" + num);







}