package com.vsjh.famconnect.famconnect;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    String name,pass;
    final EditText login_Name = (EditText) findViewById(R.id.login_Name);
    final EditText login_Paswoord = (EditText) findViewById(R.id.login_Paswoord);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button button_Login = (Button) findViewById(R.id.button_Login);

        final TextView link_Register = (TextView) findViewById(R.id.link_Register);

        link_Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerPageIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerPageIntent);
            }
        });
    }
    public void userReg(View view)
    {
        startActivity(new Intent(this, RegisterActivity.class));
    }


    public void userLogin(View view)
    {
        name = (login_Name).getText().toString();
        pass = (login_Paswoord).getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, name, pass);
    }
}
