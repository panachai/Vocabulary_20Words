package com.panachai.vocabulary_20words;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "MyContactDB";
    public static final String TB_Name = "profile";
    public static final String FLD_ID = "id";
    public static final String FLD_User = "username";
    public static final String FLD_Pass = "passwd";
    public static final String FLD_Fullname = "fullName";
    public static final String FLD_Email = "email";

    public static final String TB_Name2 = "Score";
    public static final String FLD_ID2 = "id";
    public static final String FLD_User2 = "username";
    public static final String FLD_Date = "testDate";
    public static final String FLD_Score = "score";

    public DBHelper(Context context) {
        super(context, DB_Name, null, 1); //super เรียกใช้ constructor  ของ คลาสแม่ (SQLiteOpenHelper)
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //สร้างตารางข้อมูล
        db.execSQL("create table "+TB_Name+" ("+FLD_ID+
                " integer primary key, "+FLD_User+" text,"+
                FLD_Pass+" text,"+FLD_Fullname+" text,"+FLD_Email+
                " text)"); //.execSQL ไว้ใช้รัน SQLite ไม่จำเป็นต้องประกาศ size

        db.execSQL("create table "+TB_Name2+" ("+FLD_ID2+
                " integer primary key, "+FLD_User2+" text,"+
                FLD_Date+" date,"+FLD_Score+" integer)"); //.execSQL ไว้ใช้รัน SQLite ไม่จำเป็นต้องประกาศ size
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //เขียนดักว่าถ้ามีการเรียกใช้ db ซ้ำ จะ drop ของเก่าแล้วสร้างใหม่
        db.execSQL("drop table if exists "+TB_Name);
        db.execSQL("drop table if exists "+TB_Name2);
        onCreate(db);
    }

    //Data Manipulation
    //Insert new Profile
    public boolean insertProfile(String user,String pass,String fullname,String email){
        //กำหนดให้สามารถเขียนข้อมูลลงในตารางข้อมูลได้
        //update delete insert ต้องใช้ getWritableDatabase
        SQLiteDatabase db = this.getWritableDatabase();
        //select ใช้ readable

        //กำหนดค่าที่จะเพิ่มลงในตารางข้อมูล ด้วยคลาส ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_User,user);
        contentValues.put(FLD_Pass,pass);
        contentValues.put(FLD_Fullname,fullname);
        contentValues.put(FLD_Email,email);
        db.insert(TB_Name,null,contentValues); //null คือใส่เงื่อนไขในการ insert
        return true;
    }

    //Query Data
    //เวลา Select จะใช้ผ่าน cursor
    public Cursor getProfile(int id){
        //กำหนดให้อ่านข้อมูลจากตารางได้อย่างเดียว
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name+" where "+FLD_ID+"="+id,null); //null คือเงื่อนไข where (ในกรณีไม่ได้ hardcode)
        return rs;
    }

    //เวลา Select จะใช้ผ่าน cursor
    public boolean checklogin(String email){
        //กำหนดให้อ่านข้อมูลจากตารางได้อย่างเดียว
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name+" where "+FLD_Email+"="+email,null); //null คือเงื่อนไข where (ในกรณีไม่ได้ hardcode)

        rs.moveToFirst();

        if(rs.getCount()>0){
            return true;
        }else return false;

    }

    //Uppdate Data
    public boolean updateProfile(int id,String pass,String fullname,String email){ //ไม่มีชื่อ เพราะเราไม่ต้องการให้เปลี่ยน primary key
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //ไว้เขียน empty ด้วย
        contentValues.put(FLD_Pass,pass);
        contentValues.put(FLD_Fullname,fullname);
        contentValues.put(FLD_Email,email);
        //Syntax update : table name , ค่าที่ต้องการแก้ , where ฟิลไหน , ค่าที่ต้องการ where
        db.update(TB_Name,contentValues,FLD_ID+"=?",new String[] {Integer.toString(id)});
        return true;
    }

/*
    public int deleteContact (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TB_Name,FLD_ID+"=?", new String[]{Integer.toString(id)});

        return result;
    }
*/

    //Get All Record
    public ArrayList<String> getAllProfile(){
        //ประกาศ ArrayList สำหรับเก็บข้อมูลทุก record ที่จะคืนกลับ
        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name,null);
        rs.moveToFirst(); //cursor ไป record แรก

        //อ่านข้อมูลจนกว่าจะครบทุก record
        while(rs.isAfterLast() == false){ //.isAfterLast() cursor เลย end of file แล้วหรือยัง
            //เพิ่มข้อมูลแต่ละ record ลงใน arraylist
            arrayList.add(rs.getString(rs.getColumnIndex(FLD_User)));
            rs.moveToNext();
        }
        return arrayList;
    }

    //-----------------------------------------------------------------------------//

    //Insert new Score
    public boolean insertScore(String user,String testDate,Integer score){
        //กำหนดให้สามารถเขียนข้อมูลลงในตารางข้อมูลได้
        //update delete insert ต้องใช้ getWritableDatabase
        SQLiteDatabase db = this.getWritableDatabase();
        //select ใช้ readable

        //กำหนดค่าที่จะเพิ่มลงในตารางข้อมูล ด้วยคลาส ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_User2,user);
        contentValues.put(FLD_Date,testDate);
        contentValues.put(FLD_Score,score);
        db.insert(TB_Name2,null,contentValues); //null คือใส่เงื่อนไขในการ insert
        return true;
    }

    //Query Data
    //เวลา Select จะใช้ผ่าน cursor
    public Cursor getScore(int id){
        //กำหนดให้อ่านข้อมูลจากตารางได้อย่างเดียว
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name2+" where "+FLD_ID2+"="+id,null); //null คือเงื่อนไข where (ในกรณีไม่ได้ hardcode)
        return rs;
    }

/*
    public int deleteContact (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TB_Name,FLD_ID+"=?", new String[]{Integer.toString(id)});

        return result;
    }
*/

    //Get All Record
    public ArrayList<String> getAllScore(){
        //ประกาศ ArrayList สำหรับเก็บข้อมูลทุก record ที่จะคืนกลับ
        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name2,null);
        rs.moveToFirst(); //cursor ไป record แรก

        //อ่านข้อมูลจนกว่าจะครบทุก record
        while(rs.isAfterLast() == false){ //.isAfterLast() cursor เลย end of file แล้วหรือยัง
            //เพิ่มข้อมูลแต่ละ record ลงใน arraylist
            arrayList.add(rs.getString(rs.getColumnIndex(FLD_User2)));
            arrayList.add(rs.getString(rs.getColumnIndex(FLD_Score)));
            rs.moveToNext();
        }
        return arrayList;
    }



}
