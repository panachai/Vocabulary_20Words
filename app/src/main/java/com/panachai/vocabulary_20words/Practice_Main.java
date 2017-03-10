package com.panachai.vocabulary_20words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Practice_Main extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioGroup radioGroup6;
    private RadioGroup radioGroup7;
    private RadioGroup radioGroup8;
    private RadioGroup radioGroup9;
    private RadioGroup radioGroup10;
    private RadioButton radioGroup1Button;
    private RadioButton radioGroup2Button;
    private RadioButton radioGroup3Button;
    private RadioButton radioGroup4Button;
    private RadioButton radioGroup5Button;
    private RadioButton radioGroup6Button;
    private RadioButton radioGroup7Button;
    private RadioButton radioGroup8Button;
    private RadioButton radioGroup9Button;
    private RadioButton radioGroup10Button;
    private Button btnComplete;
    private boolean statusRadio;
    private int score;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice__main);


        addListenerOnButton();
    }

    /* //ไม่ใช้อันนี้
    //ถ้าใจะใช้ต้องเพิ่มอันนี้ใน radio button [android:onClick="onRadioButtonClicked"]

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1_1:
                if (checked){
                    System.out.println("1.1");
                }
                    // Pirates are the best
                    break;
            case R.id.radioButton1_2:
                if (checked){
                    System.out.println("1.2");
                }
                    // Ninjas rule
                    break;
        }
    }*/


    public void addListenerOnButton() {

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup01);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup02);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup03);
        radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup04);
        radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup05);
        radioGroup6 = (RadioGroup) findViewById(R.id.radioGroup06);
        radioGroup7 = (RadioGroup) findViewById(R.id.radioGroup07);
        radioGroup8 = (RadioGroup) findViewById(R.id.radioGroup08);
        radioGroup9 = (RadioGroup) findViewById(R.id.radioGroup09);
        radioGroup10 = (RadioGroup) findViewById(R.id.radioGroup10);

        btnComplete = (Button) findViewById(R.id.bt_complete);

        btnComplete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                score = 0;

                radioGroup1Button = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
                radioGroup2Button = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());
                radioGroup3Button = (RadioButton) findViewById(radioGroup3.getCheckedRadioButtonId());
                radioGroup4Button = (RadioButton) findViewById(radioGroup4.getCheckedRadioButtonId());
                radioGroup5Button = (RadioButton) findViewById(radioGroup5.getCheckedRadioButtonId());
                radioGroup6Button = (RadioButton) findViewById(radioGroup6.getCheckedRadioButtonId());
                radioGroup7Button = (RadioButton) findViewById(radioGroup7.getCheckedRadioButtonId());
                radioGroup8Button = (RadioButton) findViewById(radioGroup8.getCheckedRadioButtonId());
                radioGroup9Button = (RadioButton) findViewById(radioGroup9.getCheckedRadioButtonId());
                radioGroup10Button = (RadioButton) findViewById(radioGroup10.getCheckedRadioButtonId());

                //radioGroup10.getCheckedRadioButtonId() ใช้ get ว่าเลือก radio ไหน

                //radioGroup10Button.getText() เรียกค่าขึ้นมา
                //radioGroup10.check(-1)

                statusRadio = true;


                if (radioGroup1.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup1 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup1Button.getText().equals("Thai")) {
                        score++;
                        //System.out.println("ถูกข้อ 1");
                    }
                }

                if (radioGroup2.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup2 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup2Button.getText().equals("Japan")) {
                        score++;
                        //System.out.println("ถูกข้อ 2");
                    }
                }

                if (radioGroup3.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup3 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup3Button.getText().equals("Morocco")) {
                        score++;
                        //System.out.println("ถูกข้อ 3");
                    }
                }

                if (radioGroup4.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup4 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup4Button.getText().equals("Sweden")) {
                        score++;
                        //System.out.println("ถูกข้อ 4");
                    }
                }

                if (radioGroup5.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup5 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup5Button.getText().equals("United Kingdom")) {
                        score++;
                        //System.out.println("ถูกข้อ 5");
                    }
                }

                if (radioGroup6.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup6 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup6Button.getText().equals("Singapore")) {
                        score++;
                        //System.out.println("ถูกข้อ 6");
                    }
                }

                if (radioGroup7.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup7 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup7Button.getText().equals("Switzerland")) {
                        score++;
                        //System.out.println("ถูกข้อ 7");
                    }
                }

                if (radioGroup8.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup8 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup8Button.getText().equals("Saudi Arabia")) {
                        score++;
                        //System.out.println("ถูกข้อ 8");
                    }
                }

                if (radioGroup9.getCheckedRadioButtonId() == -1) {
                    System.out.println("RadioGroup9 : ไม่ได้ติก");
                    statusRadio = false;
                } else {

                    if (radioGroup9Button.getText().equals("Russia")) {
                        score++;
                        //System.out.println("ถูกข้อ 9");
                    }
                }

                if (radioGroup10.getCheckedRadioButtonId() == -1) {//ถ้าเป็น -1 คือยังไม่ได้เลือก
                    System.out.println("RadioGroup10 : ไม่ได้ติก");
                    statusRadio = false;
                } else {
                    if (radioGroup10Button.getText().equals("Taiwan")) {
                        score++;
                        //System.out.println("ถูกข้อ 10");
                    }
                }

                if (statusRadio) {

                    String currentDate = String.valueOf(android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a", new java.util.Date()));

                    Calendar c = Calendar.getInstance();
                    System.out.println("Current time => " + c.getTime());

                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String formattedDate = df.format(c.getTime());

//mydb.getUsername()
                    try {//แก้ user และ format date ต่อด้วย
                        mydb.insertScore("sss", formattedDate, score);
                    } catch (ParseException pe) {

                    }


                    Toast.makeText(Practice_Main.this,
                            "You Score : " + score + "date : " + formattedDate
                            , Toast.LENGTH_SHORT).show();
                }


                //ยังไม่ได้เช็ค คะแนน รอทำต่อ
            }

        });
    }

}



