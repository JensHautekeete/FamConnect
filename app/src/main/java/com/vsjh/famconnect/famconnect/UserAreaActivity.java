 package com.vsjh.famconnect.famconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

 public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView area_Title = (TextView) findViewById(R.id.area_Title);
        final TextView area_Username = (TextView) findViewById(R.id.area_Username);
    }
}
