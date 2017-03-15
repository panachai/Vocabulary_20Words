package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DBHelper mydb;
    EditText et_email;
    EditText et_Password;
    EditText et_RePassword;

    EditText et_fullname;
    EditText et_username;

    Button bt_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mydb = new DBHelper(this);

        et_username = (EditText) findViewById(R.id.et_username);
        et_Password = (EditText) findViewById(R.id.et_Password);
        et_RePassword = (EditText) findViewById(R.id.et_RePassword);
        et_fullname = (EditText) findViewById(R.id.et_fullname);
        et_email = (EditText) findViewById(R.id.et_EmailRegister);

        bt_complete = (Button) findViewById(R.id.bt_complete);
        bt_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });
    }

    public void attemptRegister() {
        String username = et_username.getText().toString();
        String password = et_Password.getText().toString();
        String fullname = et_fullname.getText().toString();
        String email = et_email.getText().toString();

        boolean cancel = false;
        View focusView = null;

        et_username.setError(null);
        et_Password.setError(null);
        et_RePassword.setError(null);
        et_fullname.setError(null);
        et_email.setError(null);


//checkUser
        if (TextUtils.isEmpty(email)) {   //เช็คค่าว่าง
            et_email.setError(getString(R.string.error_field_required));
            focusView = et_email;
            cancel = true;
        } else if (!isEmailValid(email)) {  //เช็ค @
            et_email.setError(getString(R.string.error_invalid_email));
            focusView = et_email;
            cancel = true;
        } else if (mydb.checkUser(username, email).equals("email0")) {
            et_email.setError("Email Already (Register Fail)");
            focusView = et_email;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            et_Password.setError(getString(R.string.error_field_required));
            focusView = et_Password;
            cancel = true;
        }

        if (!isPasswordValid(password)) {
            et_Password.setError(getString(R.string.error_invalid_password));
            focusView = et_Password;
            cancel = true;
        }

        if (!(et_Password.getText().toString().equals(et_RePassword.getText().toString()))) {
            et_RePassword.setError("Password not match");
            focusView = et_RePassword;
            cancel = true;
        }

        if (TextUtils.isEmpty(username)) {   //เช็คค่าว่าง
            et_username.setError(getString(R.string.error_field_required));
            focusView = et_username;
            cancel = true;
        } else if (mydb.checkUser(username, email).equals("user0")) {
            et_username.setError("User Already (Register Fail)");
            focusView = et_username;
            cancel = true;
        }


        if (cancel) {
            focusView.requestFocus();
        } else {
            long result = mydb.insertProfile(username, password, fullname, email);
            if (result > 0) {
                Toast.makeText(RegisterActivity.this,
                        "Register Success", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivityUser.class);
                startActivity(intent);

            } else {
                Toast.makeText(RegisterActivity.this,
                        "SQL error (Register Fail)", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}
