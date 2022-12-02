package com.example.volleyballapp;


import android.os.Parcelable;

import java.util.Date;
import android.os.Parcel;





public class ASet implements Parcelable {

    private int setNumber;
    private int homeScore, awayScore;
    private int homeAce, homeBlock, homeKill;
    private int awayAce, awayBlock, awayKill;
    private int homeOppAtkError, homeOppServeError, homeOppOtherError;
    private int awayOppAtkError, awayOppServeError, awayOppOtherError;
    private String gameDocID, setDocID;

    public ASet(int setNumber, int homeScore, int awayScore, int homeAce, int homeBlock, int homeKill,
                     int awayAce, int awayBlock, int awayKill, int homeOppAtkError,
                     int homeOppServeError, int homeOppOtherError, int awayOppAtkError,
                     int awayOppServeError, int awayOppOtherError, String gameDocID, String setDocID) {
        this.setNumber = setNumber;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeAce = homeAce;
        this.homeBlock = homeBlock;
        this.homeKill = homeKill;
        this.awayAce = awayAce;
        this.awayBlock = awayBlock;
        this.awayKill = awayKill;
        this.homeOppAtkError = homeOppAtkError;
        this.homeOppServeError = homeOppServeError;
        this.homeOppOtherError = homeOppOtherError;
        this.awayOppAtkError = awayOppAtkError;
        this.awayOppServeError = awayOppServeError;
        this.awayOppOtherError = awayOppOtherError;
        this.gameDocID = gameDocID;
        this.setDocID = setDocID;
    }

    public ASet() {
        setNumber = 0;
        homeScore = 0;
        awayScore = 0;
        homeAce = 0;
        homeBlock = 0;
        homeKill = 0;
        awayAce = 0;
        awayBlock = 0;
        awayKill = 0;
        homeOppAtkError = 0;
        homeOppServeError = 0;
        homeOppOtherError = 0;
        awayOppAtkError = 0;
        awayOppServeError = 0;
        awayOppOtherError = 0;
        gameDocID = "none";
        setDocID = "none";
    }

    public ASet(int setNumber, String gameDocID) {
        this.setNumber = setNumber;
        homeScore = 0;
        awayScore = 0;
        homeAce = 0;
        homeBlock = 0;
        homeKill = 0;
        awayAce = 0;
        awayBlock = 0;
        awayKill = 0;
        homeOppAtkError = 0;
        homeOppServeError = 0;
        homeOppOtherError = 0;
        awayOppAtkError = 0;
        awayOppServeError = 0;
        awayOppOtherError = 0;
        this.gameDocID = gameDocID;
        setDocID = "none";
    }



    public static final Creator<ASet> CREATOR = new Creator<ASet>() {
        @Override
        public ASet createFromParcel(Parcel in) {
            return new ASet(in);
        }

        @Override
        public ASet[] newArray(int size) {
            return new ASet[size];
        }
    };

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getGameDocID() {
        return gameDocID;
    }

    public void setGameDocID(String gameDocID) {
        this.gameDocID = gameDocID;
    }

    public String getSetDocID() {
        return setDocID;
    }

    public void setSetDocID(String setDocID) {
        this.setDocID = setDocID;
    }

    public int getHomeAce() {
        return homeAce;
    }

    public void setHomeAce(int homeAce) {
        this.homeAce = homeAce;
    }

    public int getHomeBlock() {
        return homeBlock;
    }

    public void setHomeBlock(int homeBlock) {
        this.homeBlock = homeBlock;
    }

    public int getHomeKill() {
        return homeKill;
    }

    public void setHomeKill(int homeKill) {
        this.homeKill = homeKill;
    }

    public int getAwayAce() {
        return awayAce;
    }

    public void setAwayAce(int awayAce) {
        this.awayAce = awayAce;
    }

    public int getAwayBlock() {
        return awayBlock;
    }

    public void setAwayBlock(int awayBlock) {
        this.awayBlock = awayBlock;
    }

    public int getAwayKill() {
        return awayKill;
    }

    public void setAwayKill(int awayKill) {
        this.awayKill = awayKill;
    }

    public int getHomeOppAtkError() {
        return homeOppAtkError;
    }

    public void setHomeOppAtkError(int homeOppAtkError) {
        this.homeOppAtkError = homeOppAtkError;
    }

    public int getHomeOppServeError() {
        return homeOppServeError;
    }

    public void setHomeOppServeError(int homeOppServeError) {
        this.homeOppServeError = homeOppServeError;
    }

    public int getHomeOppOtherError() {
        return homeOppOtherError;
    }

    public void setHomeOppOtherError(int homeOppOtherError) {
        this.homeOppOtherError = homeOppOtherError;
    }

    public int getAwayOppAtkError() {
        return awayOppAtkError;
    }

    public void setAwayOppAtkError(int awayOppAtkError) {
        this.awayOppAtkError = awayOppAtkError;
    }

    public int getAwayOppServeError() {
        return awayOppServeError;
    }

    public void setAwayOppServeError(int awayOppServeError) {
        this.awayOppServeError = awayOppServeError;
    }

    public int getAwayOppOtherError() {
        return awayOppOtherError;
    }

    public void setAwayOppOtherError(int awayOppOtherError) {
        this.awayOppOtherError = awayOppOtherError;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(setNumber);
        parcel.writeInt(homeScore);
        parcel.writeInt(awayScore);
        parcel.writeInt(homeAce);
        parcel.writeInt(homeBlock);
        parcel.writeInt(homeKill);
        parcel.writeInt(awayAce);
        parcel.writeInt(awayBlock);
        parcel.writeInt(awayKill);
        parcel.writeInt(homeOppAtkError);
        parcel.writeInt(homeOppServeError);
        parcel.writeInt(homeOppOtherError);
        parcel.writeInt(awayOppAtkError);
        parcel.writeInt(awayOppServeError);
        parcel.writeInt(awayOppOtherError);
        parcel.writeString(gameDocID);
        parcel.writeString(setDocID);
    }

    protected ASet(Parcel in) {
        setNumber = in.readInt();
        homeScore = in.readInt();
        awayScore = in.readInt();
        homeAce = in.readInt();
        homeBlock = in.readInt();
        homeKill = in.readInt();
        awayAce = in.readInt();
        awayBlock = in.readInt();
        awayKill = in.readInt();
        homeOppAtkError = in.readInt();
        homeOppServeError = in.readInt();
        homeOppOtherError = in.readInt();
        awayOppAtkError = in.readInt();
        awayOppServeError = in.readInt();
        awayOppOtherError = in.readInt();
        gameDocID = in.readString();
        setDocID = in.readString();

    }
}
