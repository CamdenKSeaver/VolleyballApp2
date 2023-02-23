package com.example.volleyballapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;


import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import java.util.ArrayList;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static String presentGameDocID;
    public static String set1DocID;
    public static String set2DocID;
    public static String set3DocID;
    public static Game currentGame;
    ASet currentSet;
    BottomNavigationView bottomNavigationView;
    boolean loggedIn =false;

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
    EditText homeTeamName;
    EditText awayTeamName;
    TextView homeAtmp;
    TextView awayAtmp;
    TextView home1T;
    TextView home2T;
    TextView home3T;
    TextView away1T;
    TextView away2T;
    TextView away3T;


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
    Button homeAtmpButton;
    Button awayAtmpButton;
    Button home1;
    Button home2;
    Button home3;
    Button away1;
    Button away2;
    Button away3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        currentGame = new Game();
        currentSet = currentGame.getSets().get(0);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);




    }







    Home firstFragment = new Home();
    Scoreboard secondFragment = new Scoreboard();
    FullScoreboard thirdFragment = new FullScoreboard();
    PrivateGames fourthFragment = new PrivateGames();
    secondHome fifthFragment = new secondHome();


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
        homeAtmpButton = findViewById(R.id.homeAtmpButton);
        awayAtmpButton = findViewById(R.id.awayAtmpButton);
        homeAtmp = findViewById(R.id.homeAtmp);
        awayAtmp = findViewById(R.id.awayAtmp);
        home1T = findViewById(R.id.home1text);
        home2T =findViewById(R.id.home2text);
        home3T =findViewById(R.id.home3text);
        away1T =findViewById(R.id.away1text);
        away2T= findViewById(R.id.away2text);
        away3T = findViewById(R.id.away3text);
        home1 = findViewById(R.id.home1);
        home2 =  findViewById(R.id.home2);
        home3 = findViewById(R.id.home3);
        away1= findViewById(R.id.away1);
        away2 = findViewById(R.id.away2);
        away3= findViewById(R.id.away3);


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
                awayAtmpButton.bringToFront();
                homeAtmpButton.bringToFront();
                return true;


            case R.id.awayScoreButton:

                awayAtmpButton.bringToFront();
                homeAtmpButton.bringToFront();
                currentSet.setAwayScore(currentSet.getAwayScore() + 1);
                awayScore.setText("" + currentSet.getAwayScore());
                awayAtmpButton.bringToFront();
                homeAtmpButton.bringToFront();
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


            case R.id.homeAtmpButton:


                currentSet.setHomeAtmp(currentSet.getHomeAtmp() + 1);
                homeAtmp.setText("" + currentSet.getHomeAtmp());

                return true;
            case R.id.awayAtmpButton:


                currentSet.setAwayAtmp(currentSet.getAwayAtmp() + 1);
                awayAtmp.setText("" + currentSet.getAwayAtmp());

                return true;
            case R.id.home1:


                currentSet.setHome1(currentSet.getHome1() + 1);
                home1T.setText("" + currentSet.getHome1());

                return true;
            case R.id.home2:


                currentSet.setHome2(currentSet.getHome2() + 1);
                home2T.setText("" + currentSet.getHome2());

                return true;
            case R.id.home3:


                currentSet.setHome3(currentSet.getHome3() + 1);
                home3T.setText("" + currentSet.getHome3());

                return true;
            case R.id.away1:


                currentSet.setAway1(currentSet.getAway1() + 1);
                away1.setText("" + currentSet.getAway1());

                return true;
            case R.id.away2:


                currentSet.setAway2(currentSet.getAway2() + 1);
                away2.setText("" + currentSet.getAway2());

                return true;
            case R.id.away3:


                currentSet.setAway3(currentSet.getAway3() + 1);
                away3.setText("" + currentSet.getAway3());

                return true;


        }
        return false;

    }
    boolean editingGame = false;
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
        saveGame = findViewById(R.id.saveButton);
        awayTeamName = findViewById(R.id.awayTeamName);
        homeTeamName = findViewById(R.id.homeTeamName);

        homeTeamName.setText(currentGame.getHomeTeam());
        awayTeamName.setText(currentGame.getAwayTeam());
        currentGame.setAwayTeam(awayTeamName.getText().toString());
        currentGame.setHomeTeam(homeTeamName.getText().toString());
        homeKill.setText(""+ currentSet.getHomeKill() );
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
        awayTeamName.setText(currentGame.getAwayTeam());
        homeTeamName.setText(currentGame.getHomeTeam());
        if(editingGame == false){
            saveGame.setText("Save Game");

        }
        else
            saveGame.setText("Save Changes");

    }

    public void setClicked(View v) {
        setNumber = findViewById(R.id.setNumber);
        switch (v.getId()) {

            case R.id.Set1:
                currentSet = currentGame.getSets().get(0);
                awayTeamName = findViewById(R.id.awayTeamName);
                homeTeamName = findViewById(R.id.homeTeamName);
                currentGame.setAwayTeam(awayTeamName.getText().toString());
                currentGame.setHomeTeam(homeTeamName.getText().toString());
                updateUI();
                setNumber.setText("1");
                break;

            case R.id.Set2:
                currentSet = currentGame.getSets().get(1);
                awayTeamName = findViewById(R.id.awayTeamName);
                homeTeamName = findViewById(R.id.homeTeamName);
                currentGame.setAwayTeam(awayTeamName.getText().toString());
                currentGame.setHomeTeam(homeTeamName.getText().toString());
                updateUI();
                setNumber.setText("2");
                break;

            case R.id.Set3:
                currentSet = currentGame.getSets().get(2);
                awayTeamName = findViewById(R.id.awayTeamName);
                homeTeamName = findViewById(R.id.homeTeamName);
                currentGame.setAwayTeam(awayTeamName.getText().toString());
                currentGame.setHomeTeam(homeTeamName.getText().toString());
                updateUI();
                setNumber.setText("3");
                break;


        }

    }





public boolean onScoreBoard = false;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:

                if (onScoreBoard == true){
                    homeTeamName = findViewById(R.id.homeTeamName);
                    awayTeamName = findViewById(R.id.awayTeamName);
                    currentGame.setHomeTeam(homeTeamName.getText().toString());
                    currentGame.setAwayTeam(awayTeamName.getText().toString());
                    onScoreBoard= false;

                }
                if(loggedIn == false){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fifthFragment).commit();
                }
                return true;

            case R.id.scoreboard:
                onScoreBoard= true;

                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commitNow();
                homeTeamName = findViewById(R.id.homeTeamName);
                awayTeamName = findViewById(R.id.awayTeamName);

                updateUI();
                return true;

//            case R.id.publicGames:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
//                return true;


            case R.id.privateGames:

                if (onScoreBoard == true){
                    homeTeamName = findViewById(R.id.homeTeamName);
                    awayTeamName = findViewById(R.id.awayTeamName);
                    currentGame.setHomeTeam(homeTeamName.getText().toString());
                    currentGame.setAwayTeam(awayTeamName.getText().toString());
                    onScoreBoard= false;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourthFragment).commitNow();

                displayData2();
                return true;
        }
return true;
    }


    public void test(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commitNow();
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

    TextView welcome;
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

                                firebaseHelper.addUserToFirestore(userName,firebaseHelper.getmAuth().getUid());
                              //  firebaseHelper.attachReadDataToUser();

//                                Intent intent = new Intent(SignInActivity.this, SelectActionActivity.class);
//                                startActivity(intent);
                                bottomNavigationView.setVisibility(View.VISIBLE);
                                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fifthFragment).commitNow();
                                loggedIn = true;
                                welcome = findViewById(R.id.welcome);

                                welcome.setText("Welcome to Volleyball Stats Tracker " + userName + "!");




                            }
                            else {
                                try {
                                    throw task.getException();
                                } catch (FirebaseAuthInvalidCredentialsException e) {
                                    // poorly formatted email address
                                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + userName + " " + password + e.getMessage());
                                } catch (FirebaseAuthEmailException e) {
                                    // duplicate email used
                                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + userName + " " + password + e.getMessage());
                                } catch (Exception e) {
                                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Sign up failed for " + userName + " " + password + e.getMessage());
                                }

                                // if sign up fails, display a message to the user along with the exception from firebase auth
                                Log.d(TAG, "Sign up failed for " + userName + " " + password +
                                        " because of \n"+ task.getException());


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
                                bottomNavigationView.setVisibility(View.VISIBLE);
                                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fifthFragment).commitNow();

                                welcome = findViewById(R.id.welcome);

                                welcome.setText("Welcome to Volleyball Stats Tracker " + userName+ "!");
                                loggedIn = true;

                            }
                            else {
                                Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
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


    public void addGameButtonClicked(View view) {
   
        currentGame = new Game();
        currentSet = currentGame.getSets().get(0);
        editingGame = false;
        updateUI();
        Log.d("Denna", "made new game");



    }
    public void homeNewGame(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commitNow();
        addGameButtonClicked(view);
    }

    Button saveGame;
    public void saveGame(View view) {
        awayTeamName = findViewById(R.id.awayTeamName);
        homeTeamName = findViewById(R.id.homeTeamName);
        if (editingGame == false) {

            currentGame.setHomeTeam(homeTeamName.getText().toString());
            currentGame.setAwayTeam(awayTeamName.getText().toString());
            firebaseHelper.makeNewGame(currentGame);
            saveGame = findViewById(R.id.saveButton);
            saveGame.setText("Save Changes");
            editingGame = true;
        }
        else{
            currentGame.setAwayTeam(awayTeamName.getText().toString());
            currentGame.setHomeTeam(homeTeamName.getText().toString());
            firebaseHelper.editData(presentGameDocID, set1DocID, currentGame.getSets().get(0),currentGame.getHomeTeam(),currentGame.getAwayTeam());
            firebaseHelper.editData(presentGameDocID, set2DocID, currentGame.getSets().get(1),currentGame.getHomeTeam(),currentGame.getAwayTeam());
            firebaseHelper.editData(presentGameDocID, set3DocID, currentGame.getSets().get(2),currentGame.getHomeTeam(),currentGame.getAwayTeam());

        }

    }

    public void logOut(View v){
        firebaseHelper.logOutUser();
        loggedIn = false;
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
        bottomNavigationView.setVisibility(View.INVISIBLE);
    }




    public void displayData2(){

        ArrayList<Game> dataToDisplay = new ArrayList<Game>();

        ListView myGamesListView = findViewById(R.id.allGamesListView);
        myGamesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                currentGame = dataToDisplay.get(position);
                currentSet = currentGame.getSets().get(0);
                presentGameDocID = currentGame.getDocID();

                set1DocID = currentGame.getSets().get(0).getSetDocID();
                set2DocID = currentGame.getSets().get(1).getSetDocID();
                set3DocID = currentGame.getSets().get(2).getSetDocID();
                Log.i(TAG,presentGameDocID + " " + set2DocID);
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commitNow();
                editingGame = true;
                updateUI();
            }
        });

        GameAdapter myGameAdapter = new GameAdapter(this, dataToDisplay);


        myGamesListView.setAdapter(myGameAdapter);
        firebaseHelper.readData(myGameAdapter, dataToDisplay);
        //myGameAdapter.notifyDataSetChanged();


    }
}









