package com.example.vgshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainLogin extends AppCompatActivity {

    EditText jetUser, jetPass;
    Button jbtnLoginGO;
    ImageView jivSettings;
    String user, pass, userValues, passValues, sp_character;
    //boolean switche = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        jetUser = findViewById(R.id.etUserName);
        jetPass = findViewById(R.id.etEmail);
        jbtnLoginGO = findViewById(R.id.btnLoginGO);
        jivSettings = findViewById(R.id.ivSettings);

    }

    public void jbtnLoginGO(View view) {
        user = jetUser.getText().toString();
        pass = jetPass.getText().toString();
        /*Pattern pattern = Pattern.compile("^[a-zA-Z0-9][_\\-]{4,16}$");
        Matcher matcher = pattern.matcher(user);
        Boolean matchFound = matcher.find();
        Pattern pattern2 = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,20}$");
        Matcher matcher2 = pattern2.matcher(pass);
        Boolean matchFound2 = matcher2.find();*/

        /*blank = "(\\s)*";
        mayu_min = "(a-zA-Z)*";
        numChar = "^(?:[a-z0-9])\\S{8,20}$";
        sp_caracter = "(\\p{Punct})*"; //Special character : `~!@#$%^&*()-_+=\|}{]["';:/?.,><
                           //change your all special characters to ""
        num = "^(?=\\w*\\d)$";*/

        userValues = "^(\\w*){6,12}\\S$";
        passValues = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])(?=\\w*[@#$%^&+=*])\\S{8,20}$";
        sp_character = "^(?=\\w*\\p{Punct}\\S)$";
        /*Pattern patron = Pattern.compile(blank);
        Pattern patron1 = Pattern.compile(mayu_min);*/

        /*if (user.matches("(\\s)*")) {
            Matcher matcher = patron.matcher(blank);
            matcher.find();
            Toast.makeText(this, "Please don't let blank spaces", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();
        } else if (user.matches("(a-zA-Z)*")) {
            Matcher matcher = patron1.matcher(mayu_min);
            matcher.find();
            Toast.makeText(this, "Please put mayus or min characters", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();
        } /*else if (!user.matches(numChar)) {
            Toast.makeText(this, "Please put 8 or more characters", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();
        } else if (user.matches(sp_caracter)) {
            Toast.makeText(this, "Please don't put special characters", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();;
        }*/
        /*if (!user.matches(userValues) {
            Toast.makeText(this, "Please don't let blank, don't put special characters or spaces", Toast.LENGTH_LONG).show();
            limpiar_user();
            jetUser.requestFocus();
        } else if (!pass.matches(passValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            limpiar_pass();
            jetPass.requestFocus();
        } else {
            Toast.makeText(this, "GO AHEAD DUDE!", Toast.LENGTH_LONG).show();
        }*/


        if (!user.matches(userValues)) {
            Toast.makeText(this, "Please don't let blank, don't put special characters or spaces", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();
        } else if (user.length() < 6 || user.length() > 12) {
            Toast.makeText(this, "Only characters betwen 6 and 12 digits", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();
        } else if (user.matches(sp_character)) {
            Toast.makeText(this, "don't put special characters", Toast.LENGTH_LONG).show();
        } else if (!pass.matches(passValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            jetPass.requestFocus();
        } else {
            Toast.makeText(this, "GO AHEAD DUDE!", Toast.LENGTH_LONG).show();
        }



        /*if (user.trim().isEmpty() || pass.trim().isEmpty()) {
            Toast.makeText(this, "All data is required", Toast.LENGTH_LONG).show();
        } else if (user.length() < 6 || user.length() > 10) {
            Toast.makeText(this, "Only characters betwen 6 and 10 digits", Toast.LENGTH_LONG).show();
            jetUser.requestFocus();
        } else if (user.matches(userValues)) {
            Toast.makeText(this, "Please don't put special characters", Toast.LENGTH_LONG).show();
            limpiar_user();
            jetUser.requestFocus();
        } else if (pass.length() < 6 || pass.length() > 10) {
            Toast.makeText(this, "Only characters betwen 6 and 10 digits", Toast.LENGTH_LONG).show();
            jetPass.requestFocus();
        } else if (pass.matches(passValues)) {
            Toast.makeText(this, "Please put mayus, numbers and special characters", Toast.LENGTH_LONG).show();
            limpiar_pass();
            jetPass.requestFocus();
        } else {
            Toast.makeText(this, "GO AHEAD DUDE!", Toast.LENGTH_LONG).show();
        }*/
    }
}


    /*public void limpiar_user() {
        jetUser.setText("");
    }*/

    /*public void limpiar_pass() {
        jetPass.setText("");
    }*/





