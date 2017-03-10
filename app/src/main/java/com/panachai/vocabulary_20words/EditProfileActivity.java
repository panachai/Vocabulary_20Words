package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    DBHelper mydb;
    EditText et_password, et_fullname, et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        et_password = (EditText) findViewById(R.id.et_PasswordProfile);
        et_fullname = (EditText) findViewById(R.id.et_fullnameProfile);
        et_email = (EditText) findViewById(R.id.et_emailProfile);
        //อ่านข้อมูลใน id ของผู้ติดต่อที่ส่งมาจาก MainActivity
        mydb = new DBHelper(this);


            Cursor rs = mydb.getProfile(mydb.getUsername());

            rs.moveToFirst();
            //อ่านค่าแต่ละคอลัมน์
            String password = rs.getString(rs.getColumnIndex(DBHelper.FLD_Pass));
            String fullname = rs.getString(rs.getColumnIndex(DBHelper.FLD_Fullname));
            String email = rs.getString(rs.getColumnIndex(DBHelper.FLD_Email));

            //แสดงค่าบน EditText
            et_password.setText(password);
            et_fullname.setText(fullname);
            et_email.setText(email);

        Button bt_intentDB = (Button) findViewById(R.id.bt_edit);
        bt_intentDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass = et_password.getText().toString();
                String full = et_fullname.getText().toString();
                String mail = et_email.getText().toString();


                mydb.updateProfile(mydb.getUsername(),pass,full,mail);

                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);


                Toast.makeText(EditProfileActivity.this,
                        "Edit Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
