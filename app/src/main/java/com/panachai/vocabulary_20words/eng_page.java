package com.panachai.vocabulary_20words;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class eng_page extends AppCompatActivity
        implements View.OnClickListener{

    //ประกาศออบเจ็คเพื่อชี้ไปยัง widget บนวิว
    ImageView[] imgObj = new ImageView[20];
    //TextView tvObj;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_page);

        //ทำการเชื่อมโยงออบเจ็คกับ ImageView ที่สร้างไว้บน layout
        imgObj[0] = (ImageView)findViewById(R.id.antarctica);
        imgObj[1] = (ImageView)findViewById(R.id.belgium);
        imgObj[2] = (ImageView)findViewById(R.id.brazil);
        imgObj[3] = (ImageView)findViewById(R.id.japan);
        imgObj[4] = (ImageView)findViewById(R.id.korea_north);
        imgObj[5] = (ImageView)findViewById(R.id.korea_south);
        imgObj[6] = (ImageView)findViewById(R.id.laos);
        imgObj[7] = (ImageView)findViewById(R.id.morocco);
        imgObj[8] = (ImageView)findViewById(R.id.russia);
        imgObj[9] = (ImageView)findViewById(R.id.saudi_arabia);
        imgObj[10] = (ImageView)findViewById(R.id.serbia);
        imgObj[11] = (ImageView)findViewById(R.id.singapore);
        imgObj[12] = (ImageView)findViewById(R.id.spain);
        imgObj[13] = (ImageView)findViewById(R.id.sweden);
        imgObj[14] = (ImageView)findViewById(R.id.switzerland);
        imgObj[15] = (ImageView)findViewById(R.id.taiwan);
        imgObj[16] = (ImageView)findViewById(R.id.thai);
        imgObj[17] = (ImageView)findViewById(R.id.united_kingdom);
        imgObj[18] = (ImageView)findViewById(R.id.united_states);
        imgObj[19] = (ImageView)findViewById(R.id.vietnam);

        for(int i=0; i<imgObj.length;i++){
            imgObj[i].setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        //ตัวแปรสำหรับรหัสของไฟล์เสียง
        int soundid=0;
        //ตรวจสอบว่าผู้ใช้คลิกรูปภาพใด
        switch(v.getId()){
            case R.id.antarctica:
                soundid=R.raw.antarctica;
                playAnimalSound(soundid);
                break;
            case R.id.belgium:
                soundid=R.raw.belgium;
                playAnimalSound(soundid);
                break;
            case R.id.brazil:
                soundid=R.raw.brazil;
                playAnimalSound(soundid);
                break;
            case R.id.japan:
                soundid=R.raw.japan;
                playAnimalSound(soundid);
                break;
            case R.id.korea_north:
                soundid=R.raw.korea_north;
                playAnimalSound(soundid);
                break;
            case R.id.korea_south:
                soundid=R.raw.korea_south;
                playAnimalSound(soundid);
                break;
            case R.id.laos:
                soundid=R.raw.laos;
                playAnimalSound(soundid);
                break;
            case R.id.morocco:
                soundid=R.raw.morocco;
                playAnimalSound(soundid);
                break;
            case R.id.russia:
                soundid=R.raw.russia;
                playAnimalSound(soundid);
                break;
            case R.id.saudi_arabia:
                soundid=R.raw.saudi_arabia;
                playAnimalSound(soundid);
                break;
            case R.id.serbia:
                soundid=R.raw.serbia;
                playAnimalSound(soundid);
                break;
            case R.id.singapore:
                soundid=R.raw.singapore;
                playAnimalSound(soundid);
                break;
            case R.id.spain:
                soundid=R.raw.spain;
                playAnimalSound(soundid);
                break;
            case R.id.sweden:
                soundid=R.raw.sweden;
                playAnimalSound(soundid);
                break;
            case R.id.switzerland:
                soundid=R.raw.switzerland;
                playAnimalSound(soundid);
                break;
            case R.id.taiwan:
                soundid=R.raw.taiwan;
                playAnimalSound(soundid);
                break;
            case R.id.thai:
                soundid=R.raw.thai;
                playAnimalSound(soundid);
                break;
            case R.id.united_kingdom:
                soundid=R.raw.united_kingdom;
                playAnimalSound(soundid);
                break;
            case R.id.united_states:
                soundid=R.raw.united_states;
                playAnimalSound(soundid);
                break;
            case R.id.vietnam:
                soundid=R.raw.vietnam;
                playAnimalSound(soundid);
                break;
        }

    }

    private void playAnimalSound(int sid){
        //ตรวจสอบว่ามีการเล่นไฟล์เสียงอื่นอยู่หรือไม่ ถ้ามีให้สั่งให้หยุด
        if(mPlayer != null){
            mPlayer.stop();
            mPlayer.release(); //เคลียร์ค่าออกจาก Memory
        }
        //แสดงไฟล์เสียงตามที่ผุ้ใช้เลือก
        mPlayer = MediaPlayer.create(this,sid);
        mPlayer.start();
    }



}
