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
    private int homeAtmp, awayAtmp, home1, home2, home3, away1, away2, away3;

    public ASet(int setNumber, int homeScore, int awayScore, int homeAce, int homeBlock, int homeKill,
                     int awayAce, int awayBlock, int awayKill, int homeOppAtkError,
                     int homeOppServeError, int homeOppOtherError, int awayOppAtkError,
                     int awayOppServeError, int awayOppOtherError, String gameDocID, String setDocID,int homeAtmp, int awayAtmp, int home1,int home2, int home3,int away1,int away2,int away3) {
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
        this.homeAtmp = homeAtmp;
        this.awayAtmp = awayAtmp;
        this.home1 =home1;
        this.home2 = home2;
        this.home3 = home3;
        this.away1 =away1;
        this.away2 =away2;
        this.away3 =away3;
    }

    @Override
    public String toString() {
        return "ASet{" +
                "setNumber=" + setNumber +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", homeAce=" + homeAce +
                ", homeBlock=" + homeBlock +
                ", homeKill=" + homeKill +
                ", awayAce=" + awayAce +
                ", awayBlock=" + awayBlock +
                ", awayKill=" + awayKill +
                ", homeOppAtkError=" + homeOppAtkError +
                ", homeOppServeError=" + homeOppServeError +
                ", homeOppOtherError=" + homeOppOtherError +
                ", awayOppAtkError=" + awayOppAtkError +
                ", awayOppServeError=" + awayOppServeError +
                ", awayOppOtherError=" + awayOppOtherError +
                ", gameDocID='" + gameDocID + '\'' +
                ", setDocID='" + setDocID + '\'' +", homeAtmp="+ homeAtmp+ ", awayAtmp=" + awayAtmp +", home1="+ home1 +", home2=" + home2 + ", home3=" + home3 + ", away1="+away1 +", away2="+away2 +", away3="+away3 +'}';
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
        homeAtmp = 0;
        awayAtmp = 0;
        home1 =0;
        home2 = 0;
        home3 = 0;
        away1 =0;
        away2 =0;
        away3 =0;
    }
    public ASet(int setNumber) {
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
        gameDocID = "none";
        setDocID = "none";
        homeAtmp = 0;
        awayAtmp = 0;
        home1 =0;
        home2 = 0;
        home3 = 0;
        away1 =0;
        away2 =0;
        away3 =0;
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
        homeAtmp = 0;
       awayAtmp = 0;
        home1 =0;
        home2 = 0;
        home3 = 0;
        away1 =0;
        away2 =0;
        away3 =0;
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

    public int getHomeAtmp() {
        return homeAtmp;
    }

    public void setHomeAtmp(int homeAtmp) {
        this.homeAtmp = homeAtmp;
    }

    public int getAwayAtmp() {
        return awayAtmp;
    }

    public void setAwayAtmp(int awayAtmp) {
        this.awayAtmp = awayAtmp;
    }

    public int getHome1() {
        return home1;
    }

    public void setHome1(int home1) {
        this.home1 = home1;
    }

    public int getHome2() {
        return home2;
    }

    public void setHome2(int home2) {
        this.home2 = home2;
    }

    public int getHome3() {
        return home3;
    }

    public void setHome3(int home3) {
        this.home3 = home3;
    }

    public int getAway1() {
        return away1;
    }

    public void setAway1(int away1) {
        this.away1 = away1;
    }

    public int getAway2() {
        return away2;
    }

    public void setAway2(int away2) {
        this.away2 = away2;
    }

    public int getAway3() {
        return away3;
    }

    public void setAway3(int away3) {
        this.away3 = away3;
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
        parcel.writeInt(homeAtmp);
        parcel.writeInt(awayAtmp);
        parcel.writeInt(home1);
        parcel.writeInt(home2);
        parcel.writeInt(home3);
        parcel.writeInt(away1);
        parcel.writeInt(away2);
        parcel.writeInt(away3);
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
        homeAtmp = in.readInt();
        awayAtmp = in.readInt();
        home1 = in.readInt();
        home2 = in.readInt();
        home3 = in.readInt();
        away1 = in.readInt();
        away2 = in.readInt();
        away3 = in.readInt();


    }
}
