package com.example.vgshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.example.vgshop.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class MainRegister extends AppCompatActivity {

    private EditText jetUserName, jetEmail, jetCountry, jetCity, jetPassword, jetRole, jetShopName;
    private Button jbtnRegisterGO;
    private ActivityMainBinding activityMainBinding;
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ImageView jivSettings;
    String userName, email, country, city, password, role, shopName, userNameValues, passValues, emailValues, countryValues, cityValues, roleValues, shopNameValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        mAuth = FirebaseAuth.getInstance();

     /*   jetUserName = findViewById(R.id.etUserName);
        jetEmail = findViewById(R.id.etEmail);
        jetCountry = findViewById(R.id.etCountry);
        jetCity = findViewById(R.id.etCity);
        jetPassword = findViewById(R.id.etPassword2);
        jetRole = findViewById(R.id.etRole);
        jetShopName = findViewById(R.id.etShopName);
        jbtnRegisterGO = findViewById(R.id.btnRegisterGO); */
    }

    public void jbtnRegisterGO(View view) {
        userName = jetUserName.getText().toString();
        email = jetEmail.getText().toString();
        country = jetCountry.getText().toString();
        city = jetCity.getText().toString();
        password = jetUserName.getText().toString();
        role = jetRole.getText().toString();
        shopName = jetShopName.getText().toString();

        userNameValues = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])(?=\\w*\\p{Punct})\\S{3,20}$";
        emailValues = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        countryValues = "^(\\w*){6,12}\\S$";
        cityValues = "^(\\w*){6,12}\\S$";
        passValues = "^(\\w*\\d)(\\w*[A-Z])(\\w*[a-z])(\\w*\\p{Punct})\\S{3,20}$";
        roleValues = "^(\\w*){6,12}\\S$";
        shopNameValues = "^(\\w*){6,12}\\S$";


        if (userNameValues.matches(userNameValues)) {
            Toast.makeText(this, "Please don't put special characters", Toast.LENGTH_LONG).show();
            jetUserName.requestFocus();
        } else if (userName.length() < 6 || userName.length() > 30) {
            Toast.makeText(this, "Only characters betwen 6 and 30 digits", Toast.LENGTH_LONG).show();
            jetUserName.requestFocus();
        } else if (!email.matches(emailValues)) {
            Toast.makeText(this, "Email format is not valid", Toast.LENGTH_LONG).show();
            jetEmail.requestFocus();
        } else if (!country.matches(countryValues)) {
            Toast.makeText(this, "Please don't put numbers or special characters", Toast.LENGTH_LONG).show();
            jetCountry.requestFocus();
        } else if (!city.matches(cityValues)) {
            Toast.makeText(this, "Please don't put numbers or special characters", Toast.LENGTH_LONG).show();
            jetCity.requestFocus();
        } else if (password.matches(passValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            jetPassword.requestFocus();
        } else if (!role.matches(roleValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            jetRole.requestFocus();
        } else if (!shopName.matches(shopNameValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            jetShopName.requestFocus();
        } else if (role.equals("seller") || role.equals("Seller") || role.equals("SELLER")) {
            Toast.makeText(this, "Welcome, seller of: " + shopName, Toast.LENGTH_LONG).show();
        }


    }
}

