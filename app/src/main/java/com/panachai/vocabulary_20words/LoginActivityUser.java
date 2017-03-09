package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivityUser extends AppCompatActivity {
    DBHelper mydb;
    private EditText mPassword,mUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        mydb = new DBHelper(this);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);

        Button bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        Button bt_register = (Button) findViewById(R.id.bt_register);
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivityUser.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Button bt_intentDB = (Button) findViewById(R.id.bt_intentDB);
        bt_intentDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivityUser.this, testDatabaseMain.class);
                startActivity(intent);
            }
        });

    }

    private void login() {
        String Username = mUsername.getText().toString();
        String Password = mPassword.getText().toString();


        if(mydb.checklogin(Username,Password)){
            Intent intent = new Intent(LoginActivityUser.this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivityUser.this,
                    "Email or Password not correct (Login Fail) : "+Username+" : "+mydb.checklogin(Username,Password), Toast.LENGTH_SHORT).show();

        }
    }

}
