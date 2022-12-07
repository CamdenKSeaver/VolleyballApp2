package com.example.volleyballapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GameAdapter extends ArrayAdapter<Game> {
    public GameAdapter(Context context, ArrayList<Game> GameList){
        super(context,0,GameList);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Game myGame = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview,parent, false);
        }
        TextView tvGameName =  convertView.findViewById(R.id.GameName);
        TextView tvGameName2 =  convertView.findViewById(R.id.Score);

        //  TextView tvGameDesc = (TextView) convertView.findViewById(R.id.GameDescription);

        tvGameName.setText(myGame.getHomeTeam() + " vs " + myGame.getAwayTeam());
        tvGameName2.setText("Set 1: " + myGame.getSets().get(0).getHomeScore() + " - " + myGame.getSets().get(0).getAwayScore() +
                "\nSet 2: " + myGame.getSets().get(1).getHomeScore() + " - " + myGame.getSets().get(1).getAwayScore() +
                "\nSet 3: " + myGame.getSets().get(2).getHomeScore() + " - " + myGame.getSets().get(2).getAwayScore());


        //tvGameDesc.setText(myGame.getDesc());

        return convertView;

    }
}
