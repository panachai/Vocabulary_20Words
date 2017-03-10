package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryScoreActivity extends AppCompatActivity {
    ListView lvContact;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_score);


        mydb = new DBHelper(this);
        lvContact = (ListView) findViewById(R.id.l_score);



        ArrayList arrayList = mydb.getAllScore();
        ArrayAdapter arrayAdapter = new
                ArrayAdapter(this,
                android.R.layout.simple_list_item_1,arrayList);
        lvContact.setAdapter(arrayAdapter);




    }
}
