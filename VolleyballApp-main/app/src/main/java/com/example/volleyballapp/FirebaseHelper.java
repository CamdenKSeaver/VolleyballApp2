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
    private ArrayList<ASet> myGames;
    // we don't need this yet
    // private ArrayList<Game> myItems = new ArrayList<>();


    public FirebaseHelper() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        myGames = new ArrayList<>();
    }


    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void logOutUser() {
        mAuth.signOut();
        this.uid = null;
    }

    public void attachReadDataToUser() {
        // This is necessary to avoid the issues we ran into with data displaying before it
        // returned from the asynch method calls
        if (mAuth.getCurrentUser() != null) {
            uid = mAuth.getUid();
            readData(new FirestoreCallback() {
                @Override
                public void onCallback(ArrayList<ASet> gameList) {
                    Log.d(TAG, "Inside attachReadDataToUser, onCallback " + gameList.toString());
                }
            });
        }
        else {
            Log.d(TAG, "No one logged in");
        }
    }

    public void editData(Game game) {
        // edit Game game to the database
        // this method is overloaded and incorporates the interface to handle the asynch calls
        editData(game, new FirestoreCallback() {
            @Override
            public void onCallback(ArrayList<ASet> myList) {
                Log.i(TAG, "Inside editData, onCallback " + myList.toString());
            }
        });
    }

    private void editData(Game game, FirestoreCallback firestoreCallback) {
        String docId = game.getDocID();
        db.collection("users").document(uid).collection("myGameList")
                .document(docId)
                .set(game)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.i(TAG, "Success updating document");
                        readData(firestoreCallback);
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
            public void onCallback(ArrayList<ASet> myList) {
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
                        readData(firestoreCallback);
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

    public void addData(ASet game) {
        // add Game game to the database
        // this method is overloaded and incorporates the interface to handle the asynch calls
        addData(game, new FirestoreCallback() {
            @Override
            public void onCallback(ArrayList<ASet> myList) {
                Log.i(TAG, "Inside addData, onCallback :" + myGames.toString());
            }
        });
    }


    private void addData(ASet game, FirestoreCallback firestoreCallback) {
        db.collection("users").document(uid).collection("myGameList")
                .add(game)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // This will set the docID key for the Game that was just added.
                        db.collection("users").document(uid).collection("myGameList").
                                document(documentReference.getId()).update("docID", documentReference.getId());
                        Log.i(TAG, "just added "  );
                        readData(firestoreCallback);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(TAG, "Error adding document", e);
                    }
                });
    }


    public ArrayList<ASet> getGameArrayList() {
        return myGames;
    }



/* https://www.youtube.com/watch?v=0ofkvm97i0s
This video is good!!!   Basically he talks about what it means for tasks to be asynchronous
and how you can create an interface and then using that interface pass an object of the interface
type from a callback method and access it after the callback method.  It also allows you to delay
certain things from occurring until after the onSuccess is finished.
*/

    private void readData(FirestoreCallback firestoreCallback) {
        myGames.clear();        // empties the AL so that it can get a fresh copy of data
        db.collection("users").document(uid).collection("myGameList")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot doc: task.getResult()) {
                                ASet game = doc.toObject(ASet.class);
                                myGames.add(game);
                            }

                            Log.i(TAG, "Success reading data: "+ myGames.toString());
                            firestoreCallback.onCallback(myGames);
                        }
                        else {
                            Log.d(TAG, "Error getting documents: " + task.getException());
                        }
                    }
                });
    }


    //https://stackoverflow.com/questions/48499310/how-to-return-a-documentsnapshot-as-a-result-of-a-method/48500679#48500679
    public interface FirestoreCallback {
        void onCallback(ArrayList<ASet> myList);
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

    public ArrayList<ASet> getMyGames() {
        return myGames;
    }

    public void setMyGames(ArrayList<ASet> myGames) {
        this.myGames = myGames;
    }
}



