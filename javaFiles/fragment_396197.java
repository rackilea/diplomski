package db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Handler_exercise extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "exercise_items";
    private static final int DATABASE_VERSION = 1;
    //table name
    private static final String TABLE_EXERCISE_TOP = "exercise_top";
    private static final String TABLE_EXERCISE_BOTTOM = "exercise_bottom";
    private static final String TABLE_EXERCISE_CARDIO = "exercise_cardio";
    private static final String TABLE_EXERCISE_VARIATIONS= "exercise_variations";

    //column name
    private static final String KEY_EX_ID = "ex_id";
    private static final String KEY_EX_NAME = "ex_name";
    private static final String KEY_EX_NICKNAME = "ex_nickname";
    private static final String KEY_NO_VARIATION = "ex_variation";
    private static final String KEY_MAIN_ID = "main_id";
    private static final String KEY_VARIATION_ID = "v_id";
    private static final String KEY_EX_VARIATION_NAME = "ex_variation_name";
    private static final String KEY_EX_VARIATION_STEPS= "ex_variation_steps";
    private static final String KEY_EX_VARIATION_PHOTOS = "ex_variation_photos";






    public DB_Handler_exercise(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        super.onDowngrade(db, oldVersion, newVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //create table exercise_top
        String CREATE_TABLE_TOP="CREATE TABLE IF NOT EXISTS "+TABLE_EXERCISE_TOP + "(" + KEY_EX_ID + " INTEGER PRIMARY KEY," + KEY_EX_NAME + " TEXT," + KEY_EX_NICKNAME + " TEXT," + KEY_NO_VARIATION + " INTEGER" + ")";   
        db.execSQL(CREATE_TABLE_TOP);
        //create table exercise_bottom
        String CREATE_TABLE_BOTTOM="CREATE TABLE IF NOT EXISTS " + TABLE_EXERCISE_BOTTOM+ "(" + KEY_EX_ID + " INTEGER PRIMARY KEY," + KEY_EX_NAME + " TEXT," +KEY_EX_NICKNAME + " TEXT," + KEY_NO_VARIATION + " INTEGER" +")";  
        db.execSQL(CREATE_TABLE_BOTTOM);
        //create table exercise_cardio
        String CREATE_TABLE_CARDIO="CREATE TABLE IF NOT EXISTS "+ TABLE_EXERCISE_CARDIO+ "(" + KEY_EX_ID + " INTEGER PRIMARY KEY," + KEY_EX_NAME + " TEXT," +KEY_EX_NICKNAME + " TEXT," + KEY_NO_VARIATION + " INTEGER" +")";   
        db.execSQL(CREATE_TABLE_CARDIO);
        //create table exercise_variations
        String CREATE_TABLE_VARIATION="CREATE TABLE IF NOT EXISTS "+ TABLE_EXERCISE_VARIATIONS+ "(" + KEY_MAIN_ID + " INTEGER ," + KEY_VARIATION_ID + " INTEGER,"+ KEY_EX_NAME+" TEXT,"+ KEY_EX_NICKNAME+" TEXT," + KEY_EX_VARIATION_NAME + " TEXT," +KEY_EX_VARIATION_STEPS + " TEXT," + KEY_EX_VARIATION_PHOTOS + " TEXT" +")";   
        db.execSQL(CREATE_TABLE_VARIATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
    //adding data on table_top
    public void addData_top(Table_exercise_top top){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_EX_ID, top.getEx_id());
        values.put(KEY_EX_NAME, top.getEx_name());
        values.put(KEY_EX_NICKNAME, top.getEx_nickname());
        values.put(KEY_NO_VARIATION, top.getEx_variation());
        db.insert(TABLE_EXERCISE_TOP, null, values);
        db.close();
    }
    //adding data on table_bottom
    public void addData_bottom(Table_exercise_bottom bottom){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_EX_ID, bottom.getEx_id());
        values.put(KEY_EX_NAME, bottom.getEx_name());
        values.put(KEY_EX_NICKNAME, bottom.getEx_nickname());
        values.put(KEY_NO_VARIATION, bottom.getEx_variation());
        db.insert(TABLE_EXERCISE_BOTTOM, null, values);
        db.close();
    }
    //adding data on table_cardio
    public void addData_cardio(Table_exercise_cardio cardio){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_EX_ID, cardio.getEx_id());
        values.put(KEY_EX_NAME, cardio.getEx_name());
        values.put(KEY_EX_NICKNAME, cardio.getEx_nickname());
        values.put(KEY_NO_VARIATION, cardio.getEx_variation());
        db.insert(TABLE_EXERCISE_CARDIO, null, values);
        db.close();
    }
    //adding data on table_variation
    public void addData_variation(Table_variation variation){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_MAIN_ID, variation.getMain_id());
        values.put(KEY_VARIATION_ID, variation.getV_id());
        values.put(KEY_EX_NAME, variation.getEx_name());
        values.put(KEY_EX_NICKNAME, variation.getEx_nickname());
        values.put(KEY_EX_VARIATION_NAME, variation.getVariation_name());
        values.put(KEY_EX_VARIATION_STEPS, variation.getVariation_steps());
        values.put(KEY_EX_VARIATION_PHOTOS, variation.getVariation_photos());
        db.insert(TABLE_EXERCISE_VARIATIONS, null, values);
        db.close();
    }

}