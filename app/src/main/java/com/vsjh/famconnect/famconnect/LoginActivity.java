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
    EditText L_NAME, L_PASS;
    String login_name, login_pass;
    Button button_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        L_NAME = (EditText) findViewById(R.id.login_Name);
        L_PASS = (EditText) findViewById(R.id.login_Paswoord);

        button_Login = (Button) findViewById(R.id.button_Login);

        TextView link_Register = (TextView) findViewById(R.id.link_Register);
        link_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        login_name = L_NAME.getText().toString();
        login_pass = L_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, login_name, login_pass);
    }
}
