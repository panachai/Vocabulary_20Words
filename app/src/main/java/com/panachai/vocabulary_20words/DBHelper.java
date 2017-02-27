package com.panachai.vocabulary_20words;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_Name = "MyContactDB";
    public static final String TB_Name = "contacts";
    public static final String FLD_ID = "id";
    public static final String FLD_Name = "contactname";
    public static final String FLD_EMAIL = "contactemail";
    public static final String FLD_PHONE = "contactphone";

    public DBHelper(Context context) {
        super(context, DB_Name, null, 1); //super เรียกใช้ constructor  ของ คลาสแม่ (SQLiteOpenHelper)
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //สร้างตารางข้อมูล
        db.execSQL("create table "+TB_Name+" ("+FLD_ID+
                " integer primary key, "+FLD_Name+" text,"+
                FLD_EMAIL+" text,"+FLD_PHONE+" text)"); //.execSQL ไว้ใช้รัน SQLite ไม่จำเป็นต้องประกาศ size
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //เขียนดักว่าถ้ามีการเรียกใช้ db ซ้ำ จะ drop ของเก่าแล้วสร้างใหม่
        db.execSQL("drop table if exists "+TB_Name);
        onCreate(db);
    }

    //Data Manipulation
    //Insert new contact
    public boolean insertContact(String name,String email,String phone){
        //กำหนดให้สามารถเขียนข้อมูลลงในตารางข้อมูลได้
        //update delete insert ต้องใช้ getWritableDatabase
        SQLiteDatabase db = this.getWritableDatabase();
        //select ใช้ readable

        //กำหนดค่าที่จะเพิ่มลงในตารางข้อมูล ด้วยคลาส ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_Name,name);
        contentValues.put(FLD_EMAIL,email);
        contentValues.put(FLD_PHONE,phone);
        db.insert(TB_Name,null,contentValues); //null คือใส่เงื่อนไขในการ insert
        return true;
    }

    //Query Data
    //เวลา Select จะใช้ผ่าน cursor
    public Cursor getContact(int id){
        //กำหนดให้อ่านข้อมูลจากตารางได้อย่างเดียว
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name+" where "+FLD_ID+"="+id,null); //null คือเงื่อนไข where (ในกรณีไม่ได้ hardcode)
        return rs;
    }

    //Uppdate Data
    public boolean updateContact(int id,String email,String phone){ //ไม่มีชื่อ เพราะเราไม่ต้องการให้เปลี่ยน primary key
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FLD_EMAIL,email);
        contentValues.put(FLD_PHONE,phone);
        //Syntax update : table name , ค่าที่ต้องการแก้ , where ฟิลไหน , ค่าที่ต้องการ where
        db.update(TB_Name,contentValues,FLD_ID+"=?",new String[] {Integer.toString(id)});
        return true;
    }

    public int deleteContact (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TB_Name,FLD_ID+"=?", new String[]{Integer.toString(id)});

        return result;
    }

    //Get All Record
    public ArrayList<String> getAllContact(){
        //ประกาศ ArrayList สำหรับเก็บข้อมูลทุก record ที่จะคืนกลับ
        ArrayList<String> arrayList = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery("select * from "+TB_Name,null);
        rs.moveToFirst(); //cursor ไป record แรก

        //อ่านข้อมูลจนกว่าจะครบทุก record
        while(rs.isAfterLast() == false){ //.isAfterLast() cursor เลย end of file แล้วหรือยัง
            //เพิ่มข้อมูลแต่ละ record ลงใน arraylist
            arrayList.add(rs.getString(rs.getColumnIndex(FLD_Name)));
            rs.moveToNext();
        }
        return arrayList;
    }
}
