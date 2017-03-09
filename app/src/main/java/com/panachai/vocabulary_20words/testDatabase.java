package com.panachai.vocabulary_20words;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class testDatabase extends AppCompatActivity {
    DBHelper mydb;
    EditText contactname, contactemail, contactphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        contactname = (EditText) findViewById(R.id.textName);
        contactemail = (EditText) findViewById(R.id.textEmail);
        contactphone = (EditText) findViewById(R.id.textPhone);
        //อ่านข้อมูลใน id ของผู้ติดต่อที่ส่งมาจาก MainActivity
        mydb = new DBHelper(this);
        Bundle bundle = getIntent().getExtras();
        //ตรวจสอบว่ามีการส่งค่ามาจริงไหม
        if (bundle != null) {
            //อ่านค่าที่ส่งมา
            int value = bundle.getInt("id"); //ส่งเป็น int เลย get int
            //อ่านค่าจาก SQLite โดยค้นหาตาม id ของ contact
            Cursor rs = mydb.getProfile(value);

            rs.moveToFirst();
            //อ่านค่าแต่ละคอลัมน์
            String name = rs.getString(rs.getColumnIndex(DBHelper.FLD_User));
            String email = rs.getString(rs.getColumnIndex(DBHelper.FLD_Pass));
            String phone = rs.getString(rs.getColumnIndex(DBHelper.FLD_Email));

            //แสดงค่าบน EditText
            contactname.setText(name);
            contactemail.setText(email);
            contactphone.setText(phone);
        }
    }
}