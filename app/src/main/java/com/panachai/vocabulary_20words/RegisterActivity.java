package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    DBHelper mydb = new DBHelper(this);
    EditText et_email;
    EditText et_Password;
    EditText et_fullname;
    EditText et_username;

    Button bt_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_email = (EditText) findViewById(R.id.et_EmailRegister);
        et_Password = (EditText) findViewById(R.id.et_Password);
        et_fullname = (EditText) findViewById(R.id.et_fullname);
        et_username = (EditText) findViewById(R.id.et_username);
        bt_complete = (Button) findViewById(R.id.bt_complete);
        bt_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//user,pass,fullname,email
                System.out.println(mydb.insertProfile(et_email.getText().toString(),
                        et_Password.getText().toString(),
                        et_fullname.getText().toString(),
                        et_username.getText().toString()));

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
