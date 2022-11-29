package com.example.volleyballapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;



public class Home extends Fragment {

    public Home(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_homescreen, container, false);
    }
   /* Button logInB, signUpB;
    EditText userNameET, passwordET;

    String userName, password;

    public static FirebaseHelper firebaseHelper;

    public final String TAG = "VB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_homescreen);

        firebaseHelper = new FirebaseHelper();
        logInB = findViewById(R.id.loginButton);
        signUpB = findViewById(R.id.signupButton);
        userNameET = findViewById(R.id.Username);
        passwordET = findViewById(R.id.Password);
    }


    public void signUpClicked(View view) {
        Log.i(TAG, "Sign up clicked");
        if (getValues()) {
            firebaseHelper.getmAuth().createUserWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()){

                                firebaseHelper.updateUid(firebaseHelper.getmAuth().getUid());
                                Log.d(TAG, userName + " created and logged in");



                                Intent intent = new Intent(Home.this, PrivateGames.class);
                                startActivity(intent);
                            }
                            else {
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

    public void logInClicked(View view) {
        Log.i(TAG, "Log in clicked");
        if (getValues()) {

            firebaseHelper.getmAuth().signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                firebaseHelper.updateUid(firebaseHelper.getmAuth().getUid());

                                Log.d(TAG, userName + " logged in");

                                Intent intent = new Intent(Home.this, PrivateGames.class);
                                startActivity(intent);
                            }
                            else {

                                Log.d(TAG, "Log in failed for " + userName + " " + password +
                                        " because of \n"+ task.toString());
                            }
                        }
                    });





        }
    }



    private boolean getValues() {
        userName = userNameET.getText().toString();
        password = passwordET.getText().toString();


        if (userName.length() == 0 || password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
            return false;
        }


        else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 char long", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Log.i(TAG, userName + " " + password + " is set after getValues(), return true");
            return true;
        }
    }

}
*/
}