package com.example.volleyballapp;


import android.os.Parcelable;

import java.util.Date;
import android.os.Parcel;

  



public class ASet implements Parcelable {
    private int homeScore;
    private int awayScore;
    private int homeAce;
    private int homeBlock;
    private int homeKill;
    private int homeOppAtkError;
    private int homeOppServeError;
    private int homeOppOtherError;
    private int awayAce;
    private int awayBlock;
    private int awayKill;
    private int awayOppAtkError;
    private int awayOppServeError;
    private int awayOppOtherError;
    private String gameDocID;
    private String ASetDocID;

    public ASet(int homeScore, int awayScore, int homeAce, int homeBlock, int homeKill, int homeOppAtkError, int homeOppServeError, int homeOppOtherError, int awayAce, int awayBlock, int awayKill, int awayOppAtkError, int awayOppServeError, int awayOppOtherError, String gameDocID, String ASetDocID) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeAce = homeAce;
        this.homeBlock = homeBlock;
        this.homeKill = homeKill;
        this.homeOppAtkError = homeOppAtkError;
        this.homeOppServeError = homeOppServeError;
        this.homeOppOtherError = homeOppOtherError;
        this.awayAce = awayAce;
        this.awayBlock = awayBlock;
        this.awayKill = awayKill;
        this.awayOppAtkError = awayOppAtkError;
        this.awayOppServeError = awayOppServeError;
        this.awayOppOtherError = awayOppOtherError;
        this.gameDocID = gameDocID;
        this.ASetDocID = ASetDocID;
    }


    public ASet(){
        homeAce = 0;
        homeBlock = 0;
        homeKill = 0;
        homeOppAtkError = 0;
        homeOppServeError = 0;
        homeOppOtherError = 0;
        awayAce = 0;
        awayBlock = 0;
        awayKill = 0;
        awayOppAtkError = 0;
        awayOppServeError = 0;
        awayOppOtherError = 0;
        gameDocID = "none";
        ASetDocID = "none";
    }

    public ASet(Parcel parcel) {

        homeAce = parcel.readInt();
        homeBlock = parcel.readInt();
        homeKill = parcel.readInt();
        homeOppAtkError = parcel.readInt();
        homeOppServeError = parcel.readInt();
        homeOppOtherError = parcel.readInt();
        awayAce = parcel.readInt();
        awayBlock = parcel.readInt();
        awayKill = parcel.readInt();
        awayOppAtkError = parcel.readInt();
        awayOppServeError = parcel.readInt();
        awayOppOtherError = parcel.readInt();
        gameDocID = parcel.readString();
        ASetDocID = parcel.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(homeAce);
        dest.writeInt(homeBlock);
        dest.writeInt(homeKill);
        dest.writeInt(homeOppAtkError);
        dest.writeInt(homeOppServeError);
        dest.writeInt(homeOppOtherError);
        dest.writeInt(awayAce);
        dest.writeInt(awayBlock);
        dest.writeInt(awayKill);
        dest.writeInt(awayOppAtkError);
        dest.writeInt(awayOppServeError);
        dest.writeInt(awayOppOtherError);
        dest.writeString(gameDocID);
        dest.writeString(ASetDocID);


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

    public String getGameDocID() {
        return gameDocID;
    }

    public void setGameDocID(String gameDocID) {
        this.gameDocID = gameDocID;
    }

    public String getASetDocID() {
        return ASetDocID;
    }

    public void setASetDocID(String ASetDocID) {
        this.ASetDocID = ASetDocID;
    }

    public final Parcelable.Creator<ASet> CREATOR = new
            Parcelable.Creator<ASet>() {

                @Override
                public ASet createFromParcel(Parcel parcel) {
                    return new ASet(parcel);
                }

                @Override
                public ASet[] newArray(int size) {
                    return new ASet[0];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }



}


