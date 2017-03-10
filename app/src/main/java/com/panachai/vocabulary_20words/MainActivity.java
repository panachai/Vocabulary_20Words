package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DBHelper mydb;
    EditText mainUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);
        mainUser = (EditText) findViewById(R.id.username);
        System.out.println(mydb.getUsername());
        //mainUser.setText("User : "+mydb.getUsername(), TextView.BufferType.EDITABLE);
    }

    public void THAI(View view){
        Intent intent = new Intent(this, thai_page.class);
        startActivity(intent);
    }

    public void ENG(View view){
        Intent intent = new Intent(this, eng_page.class);
        startActivity(intent);
    }

    public void PRACTICE(View view){

        Intent intent = new Intent(this, Practice_Main.class);
        startActivity(intent);
    }

    public void PROFILE(View view){

        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
    public void HISTORYSCORE(View view){

        Intent intent = new Intent(this, HistoryScoreActivity.class);
        startActivity(intent);
    }


}
