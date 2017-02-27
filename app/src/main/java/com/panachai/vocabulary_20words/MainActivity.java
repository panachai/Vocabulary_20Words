package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}
