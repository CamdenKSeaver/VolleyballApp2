package com.example.volleyballapp;

import java.io.*;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;



import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static String gameDocID;
    Game game;
    ASet currentSet;
    BottomNavigationView bottomNavigationView;

    TextView homeScores;
    TextView awayScore;
    TextView homeKill;
    TextView awayKill;
    TextView homeAce;
    TextView awayAce;
    TextView homeBlock;
    TextView awayBlock;
    TextView homeAtkErr;
    TextView awayAtkErr;
    TextView homeSrvErr;
    TextView awaySrvErr;
    TextView homeOthErr;
    TextView awayOthErr;
    TextView setNumber;
    Button homeKillButton;
    Button homeScoresButton;
    Button awayScoreButton;
    Button awayKillButton;
    Button homeAceButton;
    Button awayAceButton;
    Button homeBlockButton;
    Button awayBlockButton;
    Button homeAtkErrButton;
    Button awayAtkErrButton;
    Button homeSrvErrButton;
    Button awaySrvErrButton;
    Button homeOthErrButton;
    Button awayOthErrButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        game = new Game();
        currentSet = game.getSets().get(0);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


    }


    public void resetScores() {
        homeScores = findViewById(R.id.homeScore);
        homeScores.setText("0");

        awayScore = findViewById(R.id.awayScore);
        awayScore.setText("0");

        homeAce = findViewById(R.id.homeAce);
        homeAce.setText("0");


        awayAce = findViewById(R.id.awayAce);
        awayAce.setText("0");

        homeKill = findViewById(R.id.homeKill);
        homeKill.setText("0");

        awayKill = findViewById(R.id.awayKill);
        awayKill.setText("0");

        homeBlock = findViewById(R.id.homeBlock);
        homeBlock.setText("0");

        awayBlock = findViewById(R.id.awayBlock);
        awayBlock.setText("0");

        homeAtkErr = findViewById(R.id.homeOppAtkErr);
        homeAtkErr.setText("0");

        awayAtkErr = findViewById(R.id.awayOppAtkErr);
        awayAtkErr.setText("0");

        homeSrvErr = findViewById(R.id.homeOppSrvErr);
        homeSrvErr.setText("0");

        awaySrvErr = findViewById(R.id.awayOppSrvErr);
        awaySrvErr.setText("0");

        homeOthErr = findViewById(R.id.homeOppOthErr);
        homeOthErr.setText("0");

        awayOthErr = findViewById(R.id.awayOppOthErr);
        awayOthErr.setText("0");


    }


    Home firstFragment = new Home();
    Scoreboard secondFragment = new Scoreboard();
    PublicGames thirdFragment = new PublicGames();
    PrivateGames fourthFragment = new PrivateGames();


    public void longClick(View v) {
        currentSet.setHomeScore(currentSet.getHomeScore() - 1);
        homeScores.setText("" + currentSet.getHomeScore());
    }

    public boolean onClick(View v) {
        homeScores = findViewById(R.id.homeScore);
        awayScore = findViewById(R.id.awayScore);
        homeAce = findViewById(R.id.homeAce);
        awayAce = findViewById(R.id.awayAce);
        homeKill = findViewById(R.id.homeKill);
        awayKill = findViewById(R.id.awayKill);
        homeBlock = findViewById(R.id.homeBlock);
        awayBlock = findViewById(R.id.awayBlock);
        homeAtkErr = findViewById(R.id.homeOppAtkErr);
        awayAtkErr = findViewById(R.id.awayOppAtkErr);
        homeSrvErr = findViewById(R.id.homeOppSrvErr);
        awaySrvErr = findViewById(R.id.awayOppSrvErr);
        homeOthErr = findViewById(R.id.homeOppOthErr);
        awayOthErr = findViewById(R.id.awayOppOthErr);
        homeKillButton = findViewById(R.id.homeKillButton);
        homeScoresButton = findViewById(R.id.homeScoreButton);
        awayScoreButton = findViewById(R.id.awayScoreButton);
        homeAceButton = findViewById(R.id.homeAceButton);
        awayAceButton = findViewById(R.id.awayAceButton);
        awayKillButton = findViewById(R.id.awayKillButton);
        homeBlockButton = findViewById(R.id.homeBlockButton);
        awayBlockButton = findViewById(R.id.awayBlockButton);
        homeAtkErrButton = findViewById(R.id.homeOppAtkErrButton);
        awayAtkErrButton = findViewById(R.id.awayOppAtkErrButton);
        homeSrvErrButton = findViewById(R.id.homeOppSrvErrButton);
        awaySrvErrButton = findViewById(R.id.awayOppSrvErrButton);
        homeOthErrButton = findViewById(R.id.homeOppOthErrButton);
        awayOthErrButton = findViewById(R.id.awayOppOthErrButton);

        homeKillButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());
                currentSet.setHomeKill(currentSet.getHomeKill() - 1);
                homeKill.setText("" + currentSet.getHomeKill());
                return true;
            }

        });
        homeAceButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());
                currentSet.setHomeAce(currentSet.getHomeAce() - 1);
                homeAce.setText("" + currentSet.getHomeAce());
                return true;
            }

        });
        homeBlockButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());
                currentSet.setHomeBlock(currentSet.getHomeBlock() - 1);
                homeBlock.setText("" + currentSet.getHomeBlock());
                return true;
            }

        });
        homeAtkErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());
                currentSet.setHomeOppAtkError(currentSet.getHomeOppAtkError() - 1);
                homeAtkErr.setText("" + currentSet.getHomeOppAtkError());
                return true;
            }

        });
        homeSrvErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());
                currentSet.setHomeOppServeError(currentSet.getHomeOppServeError() - 1);
                homeSrvErr.setText("" + currentSet.getHomeOppServeError());
                return true;
            }

        });
        homeOthErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());
                currentSet.setHomeOppOtherError(currentSet.getHomeOppOtherError() - 1);
                homeOthErr.setText("" + currentSet.getHomeOppOtherError());
                return true;
            }

        });
        awayOthErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayOppOtherError(currentSet.getAwayOppOtherError() - 1);
                awayOthErr.setText("" + currentSet.getAwayOppOtherError());
                return true;
            }

        });
        awayKillButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayKill(currentSet.getAwayKill() - 1);
                awayKill.setText("" + currentSet.getAwayKill());
                return true;
            }

        });
        awayAceButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayAce(currentSet.getAwayAce() - 1);
                awayAce.setText("" + currentSet.getAwayAce());
                return true;
            }

        });
        awayBlockButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayBlock(currentSet.getAwayBlock() - 1);
                awayBlock.setText("" + currentSet.getAwayBlock());
                return true;
            }

        });
        awayAtkErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayOppAtkError(currentSet.getAwayOppAtkError() - 1);
                awayAtkErr.setText("" + currentSet.getAwayOppAtkError());
                return true;
            }

        });
        awaySrvErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayOppServeError(currentSet.getAwayOppServeError() - 1);
                awaySrvErr.setText("" + currentSet.getAwayOppServeError());
                return true;
            }

        });
        awayOthErrButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());
                currentSet.setAwayOppOtherError(currentSet.getAwayOppOtherError() - 1);
                awayOthErr.setText("" + currentSet.getAwayOppOtherError());
                return true;
            }

        });
        awayScoreButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setAwayScore(currentSet.getAwayScore() - 1);
                awayScore.setText("" + currentSet.getAwayScore());

                return true;
            }

        });
        homeScoresButton.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                currentSet.setHomeScore(currentSet.getHomeScore() - 1);
                homeScores.setText("" + currentSet.getHomeScore());

                return true;
            }

        });


        switch (v.getId()) {

            case R.id.homeScoreButton:


                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeScores.setText("" + currentSet.getHomeScore());
                return true;


            case R.id.awayScoreButton:


                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayScore.setText("" + currentSet.getAwayScore());
                return true;

            case R.id.homeAceButton:

                currentSet.setHomeAce(currentSet.getHomeAce() + 1);
                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeAce.setText("" + currentSet.getHomeAce());
                homeScores.setText("" + currentSet.getHomeScore());
                return true;

            case R.id.awayAceButton:


                currentSet.setAwayAce(currentSet.getAwayAce() + 1);
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayAce.setText("" + currentSet.getAwayAce());
                awayScore.setText("" + currentSet.getAwayScore());
                return true;

            case R.id.homeKillButton:


                currentSet.setHomeKill(currentSet.getHomeKill() + 1);
                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeKill.setText("" + currentSet.getHomeKill());
                homeScores.setText("" + currentSet.getHomeScore());
                return true;

            case R.id.awayKillButton:


                currentSet.setAwayKill(currentSet.getAwayKill() + 1);
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayKill.setText("" + currentSet.getAwayKill());
                awayScore.setText("" + currentSet.getAwayScore());
                return true;
            case R.id.homeBlockButton:


                currentSet.setHomeBlock(currentSet.getHomeBlock() + 1);
                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeBlock.setText("" + currentSet.getHomeBlock());
                homeScores.setText("" + currentSet.getHomeScore());
                return true;
            case R.id.awayBlockButton:


                currentSet.setAwayBlock(currentSet.getAwayBlock() + 1);
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayBlock.setText("" + currentSet.getAwayBlock());
                awayScore.setText("" + currentSet.getAwayScore());
                return true;
            case R.id.homeOppAtkErrButton:


                currentSet.setHomeOppAtkError(currentSet.getHomeOppAtkError() + 1);
                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeAtkErr.setText("" + currentSet.getHomeOppAtkError());
                homeScores.setText("" + currentSet.getHomeScore());
                return true;
            case R.id.awayOppAtkErrButton:


                currentSet.setAwayOppAtkError(currentSet.getAwayOppAtkError() + 1);
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayAtkErr.setText("" + currentSet.getAwayOppAtkError());
                awayScore.setText("" + currentSet.getAwayScore());
                return true;
            case R.id.homeOppSrvErrButton:


                currentSet.setHomeOppServeError(currentSet.getHomeOppServeError() + 1);
                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeSrvErr.setText("" + currentSet.getHomeOppServeError());
                homeScores.setText("" + currentSet.getHomeScore());
                return true;
            case R.id.awayOppSrvErrButton:


                currentSet.setAwayOppServeError(currentSet.getAwayOppServeError() + 1);
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awaySrvErr.setText("" + currentSet.getAwayOppServeError());
                awayScore.setText("" + currentSet.getAwayScore());
                return true;
            case R.id.homeOppOthErrButton:


                currentSet.setHomeOppOtherError(currentSet.getHomeOppOtherError() + 1);
                currentSet.setHomeScore(currentSet.getHomeScore() + 1);
                homeOthErr.setText("" + currentSet.getHomeOppOtherError());
                homeScores.setText("" + currentSet.getHomeScore());
                return true;
            case R.id.awayOppOthErrButton:


                currentSet.setAwayOppOtherError(currentSet.getAwayOppOtherError() + 1);
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayOthErr.setText("" + currentSet.getAwayOppOtherError());
                awayScore.setText("" + currentSet.getAwayScore());
                return true;


        }
        return false;

    }

    public void updateUI() {
        homeScores = findViewById(R.id.homeScore);
        awayScore = findViewById(R.id.awayScore);
        homeAce = findViewById(R.id.homeAce);
        awayAce = findViewById(R.id.awayAce);
        homeKill = findViewById(R.id.homeKill);
        awayKill = findViewById(R.id.awayKill);
        homeBlock = findViewById(R.id.homeBlock);
        awayBlock = findViewById(R.id.awayBlock);
        homeAtkErr = findViewById(R.id.homeOppAtkErr);
        awayAtkErr = findViewById(R.id.awayOppAtkErr);
        homeSrvErr = findViewById(R.id.homeOppSrvErr);
        awaySrvErr = findViewById(R.id.awayOppSrvErr);
        homeOthErr = findViewById(R.id.homeOppOthErr);
        awayOthErr = findViewById(R.id.awayOppOthErr);


        homeKill.setText("" + currentSet.getHomeKill());
        homeScores.setText("" + currentSet.getHomeScore());
        homeAce.setText("" + currentSet.getHomeAce());
        homeBlock.setText("" + currentSet.getHomeBlock());
        homeAtkErr.setText("" + currentSet.getHomeOppAtkError());
        homeSrvErr.setText("" + currentSet.getHomeOppServeError());
        homeOthErr.setText("" + currentSet.getHomeOppOtherError());

        awayKill.setText("" + currentSet.getAwayKill());
        awayScore.setText("" + currentSet.getAwayScore());
        awayAce.setText("" + currentSet.getAwayAce());
        awayBlock.setText("" + currentSet.getAwayBlock());
        awayAtkErr.setText("" + currentSet.getAwayOppAtkError());
        awaySrvErr.setText("" + currentSet.getAwayOppServeError());
        awayOthErr.setText("" + currentSet.getAwayOppOtherError());

    }

    public void setClicked(View v) {
        setNumber = findViewById(R.id.setNumber);
        switch (v.getId()) {

            case R.id.Set1:
                currentSet = game.getSets().get(0);
                updateUI();
                setNumber.setText("1");
                break;

            case R.id.Set2:
                currentSet = game.getSets().get(1);
                updateUI();
                setNumber.setText("2");
                break;

            case R.id.Set3:
                currentSet = game.getSets().get(2);
                updateUI();
                setNumber.setText("3");
                break;


        }

    }







    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                return true;

            case R.id.scoreboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                return true;

            case R.id.publicGames:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;


            case R.id.privateGames:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourthFragment).commit();
                return true;
        }
return true;
    }


//FIREBASE

    Button logInB, signUpB;
    EditText userNameET, passwordET;
    String userName, password;
    public static FirebaseHelper firebaseHelper;
    public final String TAG = "Denna";

public void setVars() {
    firebaseHelper = new FirebaseHelper();
    logInB = findViewById(R.id.loginButton);
    signUpB = findViewById(R.id.signupButton);
    userNameET = findViewById(R.id.Username);
    passwordET = findViewById(R.id.Password);
}
    public void signUpClicked(View view) {
        Log.i(TAG, "Sign up clicked");
        if (getValues()) {      // get username and password
            // Try to create an account using auth
            firebaseHelper.getmAuth().createUserWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // FOR SOME REASON IF THE CREATE USER IS NOT WORKING, THIS IS CRASHING
                            // NOT SURE WHY?  I TRIED WITH A DUPLICATE EMAIL ADDRESS AND THAT CRASHED IT.
                            // LOGCAT SHOWED THE MESSAGE BUT I COULDN'T GET IT TO SHOW IN A LOG STATEMENT

                            if (task.isSuccessful()){
                                // Sign up successful, update UI with the currently signed in user's info
                                firebaseHelper.updateUid(firebaseHelper.getmAuth().getUid());
                                Log.d(TAG, userName + " created and logged in");

                                // we will implement this later
                                // updateIfLoggedIn();
                                // firebaseHelper.attachReadDataToUser();


                            }
                            else {
                                // if sign up fails, display a message to the user along with the exception from firebase auth
                                Log.d(TAG, "Sign up failed for " + userName + " " + password +
                                        " because of \n"+ task.getResult());

                            }
                        }
                    });
        }
        else {
            Log.d(TAG, "Failed to pass getValues() method");
        }
    }

    public void LogInClicked(View view) {
        Log.i(TAG, "Log in clicked");
        if (getValues()) {        // get username and password
            // if valid, log in user and then switch to next activity
            // Try to sign into an account using auth with given email and password
            firebaseHelper.getmAuth().signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                // Sign in success, update currently signed in user's info
                                firebaseHelper.updateUid(firebaseHelper.getmAuth().getUid());

                                // we will implement this later
                                // updateIfLoggedIn();
                                // firebaseHelper.attachReadDataToUser();

                                Log.d(TAG, userName + " logged in");

                            }
                            else {
                                // if log in fails, display a message to the user along with the exception from firebase auth
                                Log.d(TAG, "Log in failed for " + userName + " " + password +
                                        " because of \n"+ task.toString());
                            }
                        }
                    });




            // if invalid - prompt message that says why signin won't go through
        }
    }


    /**
     * Helper method to get userName and password whenever one of these buttons is clicked
     * The method makes sure both EditText boxes are filled in and also ensures the password
     * is at least 6 characters long.  If those tests pass, then it will send the values on
     * to be checked by Firebase auth
     *
     * @return true if values pass these tests, false otherwise
     */
    private boolean getValues() {
        setVars();
        userName = userNameET.getText().toString();
        password = passwordET.getText().toString();

        // verify all user data is entered
        if (userName.length() == 0 || password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // verify password is at least 6 char long (otherwise firebase will deny)
        else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 char long", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Log.i(TAG, userName + " " + password + " is set after getValues(), return true");
            return true;
        }
    }

}









