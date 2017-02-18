package com.vsjh.famconnect.famconnect;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    String firstname, lastname, username, email, pass, birth;
    EditText first_name, last_name, user_name, user_email, user_pass, user_birth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        user_name = (EditText) findViewById(R.id.user_name);
        user_email = (EditText) findViewById(R.id.user_email);
        user_pass = (EditText) findViewById(R.id.user_pass);
        user_birth = (EditText) findViewById(R.id.user_birth);
    }

    public void userLog(View view)
    {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void userReg(View view)
    {
        firstname = first_name.getText().toString();
        lastname = last_name.getText().toString();
        username = user_name.getText().toString();
        email = user_email.getText().toString();
        pass = user_pass.getText().toString();
        birth = user_birth.getText().toString();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, firstname,lastname, username, email, pass,birth );
        finish();
    }
}
