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


    final EditText first_name = (EditText) findViewById(R.id.first_name);
    final EditText last_name = (EditText) findViewById(R.id.last_name);
    final EditText user_name = (EditText) findViewById(R.id.user_name);
    final EditText user_email = (EditText) findViewById(R.id.user_email);
    final EditText user_pass = (EditText) findViewById(R.id.user_pass);
    final NumberPicker numberPicker_Day = (NumberPicker) findViewById(R.id.numberPicker_Day);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final ImageView logo_register = (ImageView) findViewById(R.id.logo_register);
        final TextView register_Title = (TextView) findViewById(R.id.register_Title);


        final EditText user_email_check = (EditText) findViewById(R.id.user_email_check);
        final EditText user_pass_check = (EditText) findViewById(R.id.user_pass_check);
        final TextView register_Date_Text = (TextView) findViewById(R.id.register_Date_Text);


    //Number picker dag
        numberPicker_Day.setMaxValue(31);
        numberPicker_Day.setMinValue(1);
        numberPicker_Day.setWrapSelectorWheel(true);
    //Numberpicker maand
        final NumberPicker numberPicker_Month = (NumberPicker) findViewById(R.id.numberPicker_Month);
        numberPicker_Month.setMaxValue(12);
        numberPicker_Month.setMinValue(1);
        numberPicker_Month.setWrapSelectorWheel(true);
    //Numberpicker jaar
        final NumberPicker numberPicker_Year = (NumberPicker) findViewById(R.id.numberPicker_Year);
        numberPicker_Year.setMaxValue(2017);
        numberPicker_Year.setMinValue(1940);
        numberPicker_Year.setValue(2017);
        numberPicker_Year.setWrapSelectorWheel(false);


        final Button button_Register = (Button) findViewById(R.id.button_Register);

        //Link naar login
        final TextView link_Login = (TextView) findViewById(R.id.link_Login);
        link_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginPageIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(loginPageIntent);
            }
        });
    }

    public void userReg(View view)
    {
        firstname = first_name.getText().toString();
        lastname = last_name.getText().toString();
        username = user_name.getText().toString();
        email = user_email.getText().toString();
        pass = user_pass.getText().toString();


        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, firstname,lastname, username, email, pass );
        finish();
    }
}
