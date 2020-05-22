import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.cianm.testauth.Entity.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mFirebaseDatabase;

    private EditText mEmail, mPassword;
    private Button mRegister;
    private RadioButton rManager, rPlayer;
    private ProgressBar mProgressbar;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mEmail = (EditText) findViewById(R.id.emailField);
        mPassword = (EditText) findViewById(R.id.passwordField);
        rManager = (RadioButton) findViewById(R.id.radioManager);
        rPlayer = (RadioButton) findViewById(R.id.radioPlayer);
        mRegister = (Button) findViewById(R.id.registerBtn);
        mProgressbar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(RegisterUser.this, HomePage.class));
        }

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser fbUser = firebaseAuth.getCurrentUser();
                if (fbUser != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in" + fbUser.getUid());
                    mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("User");
                    mFirebaseDatabase.child(fbUser.getUid()).setValue(user);
                    Toast.makeText(getApplicationContext(), "Sucessfully signed in with: " + fbUser.getEmail(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterUser.this, HomePage.class));
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!rManager.isChecked() && !rPlayer.isChecked()) {
                    Toast.makeText(RegisterUser.this, "You must select either player or manager", Toast.LENGTH_LONG).show();
                }

                mProgressbar.setVisibility(View.VISIBLE);
                String type = "";
                //radio buttons
                if (rManager.isChecked()) {
                    type = "Manager";
                } else if (rPlayer.isChecked()) {
                    type = "Player";
                }
                mProgressbar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(email, password);
                user = new User(email, password, type);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgressbar.setVisibility(View.GONE);
    }
}