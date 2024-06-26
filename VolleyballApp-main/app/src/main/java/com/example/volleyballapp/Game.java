package com.example.volleyballapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class Game implements Parcelable {


    private String docID;
    private String homeTeam;
    private String awayTeam;
    private String date;
    private ArrayList<ASet> sets;

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ASet> getSets() {
        return sets;
    }

    public void setSets(ArrayList<ASet> sets) {
        this.sets = sets;
    }

    public boolean isPublicGame() {
        return publicGame;
    }

    public void setPublicGame(boolean publicGame) {
        this.publicGame = publicGame;
    }

    public String getDocID() {
        return docID;
    }

    public void setUserDocID(String userDocID) {
        this.docID = docID;
    }

    private boolean publicGame;




    public Game(String homeTeam, String awayTeam, String date, ArrayList<ASet> sets, boolean publicGame, String docID) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.sets = sets;
        this.publicGame = publicGame;
        this.docID = docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public Game(){
        homeTeam ="";
        awayTeam = "";
        date = "1234";
        sets = new ArrayList<ASet>();
        sets.add(new ASet(1));
        sets.add(new ASet(2));
        sets.add(new ASet(3));
        publicGame = false;
        docID = "";


    }

    @Override
    public String toString() {
        return "Game{" +
                "docID='" + docID + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", date='" + date + '\'' +
                ", sets=" + sets +
                ", publicGame=" + publicGame +
                '}';
    }

    protected Game(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
