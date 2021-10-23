package com.example.vgshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.vgshop.databinding.ActivityMainBinding;

public class MainLogin extends AppCompatActivity {

    private EditText etUserEmail, etUserPassword;
    private Button btnLoginGO;
    private ImageView jivSettings;
    private ActivityMainBinding activityMainBinding;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private String user, pass, userValues, passValues, sp_character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        db = FirebaseFirestore.getInstance();

        /* jetUser = findViewById(R.id.etUserEmail);
        jetPass = findViewById(R.id.etUserPassword);
        jbtnLoginGO = findViewById(R.id.btnLoginGO);
        jivSettings = findViewById(R.id.ivSettings); */

    }

    public void Login(View view) {
        String email = activityMainBinding.etUserEmail.getText().toString();
        String password = activityMainBinding.etUserPassword.getText().toString();

        userValues = "^(\\w*){6,12}\\S$";
        passValues = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])(?=\\w*[@#$%^&+=*])\\S{8,20}$";
        sp_character = "^(?=\\w*\\p{Punct}\\S)$";

        if (!user.matches(userValues)) {
            Toast.makeText(this, "Please don't let blank, don't put special characters or spaces", Toast.LENGTH_LONG).show();
            etUserEmail.requestFocus();
        } else if (user.length() < 6 || user.length() > 12) {
            Toast.makeText(this, "Only characters betwen 6 and 12 digits", Toast.LENGTH_LONG).show();
            etUserEmail.requestFocus();
        } else if (user.matches(sp_character)) {
            Toast.makeText(this, "don't put special characters", Toast.LENGTH_LONG).show();
        } else if (!pass.matches(passValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            etUserPassword.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Login Succesful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed to Login, check your data and try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }
}





