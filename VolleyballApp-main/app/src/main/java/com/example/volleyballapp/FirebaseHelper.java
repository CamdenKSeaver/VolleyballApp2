package com.example.volleyballapp;



import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
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

/**
 * The purpose of this class is to hold ALL the code to communicate with Firebase.  This class
 * will connect with Firebase auth and Firebase firestore.  Each class that needs to verify
 * authentication OR access data from the database will reference a variable of this class and
 * call a method of this class to handle the task.  Essentially this class is like a "gopher" that
 * will go and do whatever the other classes want or need it to do.  This allows us to keep all
 * our other classes clean of the firebase code and also avoid having to update firebase code
 * in many places.  This is MUCH more efficient and less error prone.
 */
public class FirebaseHelper {
    public final String TAG = "Denna";
    private static String uid = null;      // var will be updated for currently signed in user
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private ArrayList<Game> myGames;
    // any other instance vars you need

    private static String currentGameDocUID = "none";

    public FirebaseHelper() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        myGames = new ArrayList<>();
        // instantiate any other vars you need

       // makeNewGame("12-1-22 FHS vs CHS");
    }


    /**
     * This will create a new Game document in firestore.  Each game consists of
     * the game title, coachUID, and gameDocID.  It also has a collection of three sets
     * @param
     */
    public void makeNewGame(Game game) {
        if (mAuth.getUid() != null)
            uid = mAuth.getUid();
        // This is what adds the three key value-pairs of data for the Game
        Map<String, Object> gameCollection = new HashMap<>();
        gameCollection.put("GameTitle", game.getHomeTeam() + " vs " + game.getAwayTeam());
        gameCollection.put("coachUID", uid);
        gameCollection.put("gameDocID", "not set yet");
        // Add a new document with a docID = to the game date and team set by coach
        db.collection("allGames")
                .add(gameCollection)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // This will set the docID key for the Memory that was just added.
                        currentGameDocUID = documentReference.getId();
                        db.collection("allGames").
                                document(documentReference.getId()).update("gameDocID", documentReference.getId());

                        // helper method to add a set object to the sets collection for this Game document
                        addSetToGame(game,0, currentGameDocUID);
                        addSetToGame(game,1, currentGameDocUID);
                        addSetToGame(game,2, currentGameDocUID);
                        Log.i(TAG, "just added " + game.getHomeTeam() + " vs " + game.getAwayTeam());

                        Log.i(TAG, "new game docID "+currentGameDocUID);
                        MainActivity.presentGameDocID = currentGameDocUID;

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(TAG, "Error adding document", e);
                    }
                });

    }

    /**
     * Takes in the set number and the docID for the current game and adds this
     * set to the data in firestore.
     * @param setNum
     * @param gameDocID
     */

    public void addSetToGame(Game game, int setNum, String gameDocID) {
        db.collection("allGames").
                document(gameDocID).collection("sets")
                .add(game.getSets().get(setNum))
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        db.collection("allGames").document(gameDocID)
                                .collection("sets").document(documentReference.getId())
                                .update("setDocID", documentReference.getId());
                        if(setNum == 0){
                            MainActivity.set1DocID = documentReference.getId();
                        }
                        if(setNum == 1){
                            MainActivity.set2DocID = documentReference.getId();
                        }
                        if(setNum == 2){
                            MainActivity.set3DocID = documentReference.getId();
                        }

                    }
                });

    }


    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void logOutUser() {
        mAuth.signOut();
        this.uid = null;
    }

//    public void attachReadDataToUser() {
//        // This is necessary to avoid the issues we ran into with data displaying before it
//        // returned from the asynch method calls
//        if (mAuth.getCurrentUser() != null) {
//            uid = mAuth.getUid();
//        //    readData(new FirestoreCallback() {
//           //     @Override
//                public void onCallback(ArrayList<Game> gameList) {
//                    Log.d(TAG, "Inside attachReadDataToUser, onCallback " + gameList.toString());
//                }
//            });
//        }
//        else {
//            Log.d(TAG, "No one logged in");
//        }
//    }

//    public void editData(Game game) {
//        // edit Game game to the database
//        // this method is overloaded and incorporates the interface to handle the asynch calls
//        editData(game, new FirestoreCallback() {
//            @Override
//            public void onCallback(ArrayList<Game> myList) {
//                Log.i(TAG, "Inside editData, onCallback " + myList.toString());
//            }
//        });
//    }
//FirestoreCallback firestoreCallback
    public void editData(String gamedocID, String setId, ASet set ) {

        db.collection("allGames").document(gamedocID).collection("sets")
                .document(setId)
                .set(set)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.i(TAG, "Success updating document");
                      //  readData(firestoreCallback);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(TAG, "Error updating document", e);
                    }
                });
    }

    public void deleteData(Game game) {
        // delete item w from database
        // this method is overloaded and incorporates the interface to handle the asynch calls
        deleteData(game, new FirestoreCallback() {
            @Override
            public void onCallback(ArrayList<Game> myList) {
                Log.i(TAG, "Inside deleteData, onCallBack" + myList.toString());
            }
        });

    }

    private void deleteData(Game game, FirestoreCallback firestoreCallback) {
        // delete item w from database
        String docId = game.getDocID();
        db.collection("users").document(uid).collection("myGameList")
                .document(docId)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.i(TAG, game.getDate() + " successfully deleted");
                  //      readData(firestoreCallback);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(TAG, "Error deleting document", e);
                    }
                });
    }

    public void addUserToFirestore(String name, String newUID) {
        // Create a new user with their name
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        // Add a new document with a docID = to the authenticated user's UID
        db.collection("users").document(newUID)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, name + "'s user account added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding user account", e);
                    }
                });
    }

    public void addData(Game game) {
        // add Game game to the database
        // this method is overloaded and incorporates the interface to handle the asynch calls
        Log.d("Denna", "calling addData public");
        addData(game, new FirestoreCallback() {
            @Override
            public void onCallback(ArrayList<Game> myList) {
                Log.i(TAG, "Inside addData, onCallback :" + myGames.toString());
            }
        });
    }


    private void addData(Game game, FirestoreCallback firestoreCallback) {
        Log.d("Denna", "calling addData private");
        Log.d("Denna", game.toString());
        Log.d("Denna", uid);
        db.collection("users").document(uid).collection("myGameList")
                .add(game)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // This will set the docID key for the Game that was just added.
//                        db.collection("users").document(uid).collection("myGameList").
//                                document(documentReference.getId()).update("GameDocID", documentReference.getId());
                        Log.i(TAG, "just added " +game.toString() );
                     //   readData(firestoreCallback);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(TAG, "Error adding document", e);
                    }
                });
    }


    public ArrayList<Game> getGameArrayList() {
        return myGames;
    }




//(FirestoreCallback firestoreCallback
    public ArrayList<Game> readData() {
        myGames.clear();
        db.collection("allGames").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot doc: task.getResult()) {
                                Game game = new Game();
                                String names = (String) doc.get("GameTitle");
                                int index = names.indexOf(" ");
                                game.setHomeTeam(names.substring(0,index));
                                game.setAwayTeam(names.substring(index+3));
                                db.collection("allGames").
                                        document((String) doc.get("gameDocID")).collection("sets")
                                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    for (DocumentSnapshot doc : task.getResult()) {
                                                        ASet set = doc.toObject(ASet.class);
                                                        Log.i(TAG, "Success reading set: "+ set.toString());
                                                        game.getSets().add(set);
                                                    }
                                                }
                                            }
                                        });


                                myGames.add(game);
                                Log.i(TAG, "Success reading data: "+ game.toString());
                            }

                            Log.i(TAG, "Success reading data: "+ myGames.get(0).toString());
                          //  firestoreCallback.onCallback(myGames);
                        }
                        else {
                            Log.d(TAG, "Error getting documents: " + task.getException());
                        }
                    }
                });
        return myGames;

    }


    //https://stackoverflow.com/questions/48499310/how-to-return-a-documentsnapshot-as-a-result-of-a-method/48500679#48500679
    public interface FirestoreCallback {
        void onCallback(ArrayList<Game> myList);
    }



    public void updateUid(String uid) {
        this.uid = uid;
    }

   /* https://www.youtube.com/watch?v=0ofkvm97i0s
   This video is good!!!   Basically he talks about what it means for tasks to be asynchronous
   and how you can create an interface and then using that interface pass an object of the interface
   type from a callback method and access it after the callback method.  It also allows you to delay
   certain things from occurring until after the onSuccess is finished.
    */



    //https://stackoverflow.com/questions/48499310/how-to-return-a-documentsnapshot-as-a-result-of-a-method/48500679#48500679

    public String getTAG() {
        return TAG;
    }

    public static String getUid() {
        return uid;
    }

    public static void setUid(String uid) {
        FirebaseHelper.uid = uid;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    public FirebaseFirestore getDb() {
        return db;
    }

    public void setDb(FirebaseFirestore db) {
        this.db = db;
    }

    public ArrayList<Game> getMyGames() {
        return myGames;
    }

    public void setMyGames(ArrayList<Game> myGames) {
        this.myGames = myGames;
    }
}



