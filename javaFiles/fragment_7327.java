package com.my.CSVcreation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CSVCreationActivity extends Activity {
    TextView empidtxt,empnametxt,empsaltxt;
    EditText empidet,empnameet,empsalet;
    Button insetbt,viewbt;
    SQLiteDatabase myDatabase=null;
    String DataBase_Name="employeedata";
    String Table_Name="employeedetails";
    Cursor c1,c2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    empidtxt=(TextView)findViewById(R.id.tv1);
    empnametxt=(TextView)findViewById(R.id.tv2);
    empsaltxt=(TextView)findViewById(R.id.tv3);

    empidet=(EditText)findViewById(R.id.et1);
    empnameet=(EditText)findViewById(R.id.et2);
    empsalet=(EditText)findViewById(R.id.et3);

    insetbt=(Button)findViewById(R.id.bt1);
    viewbt=(Button)findViewById(R.id.bt2);

    try {
        myDatabase=this.openOrCreateDatabase(DataBase_Name, MODE_PRIVATE, null);
        System.out.println("databse has been creates.....");
        myDatabase.execSQL("create table if not exists " + Table_Name + "(empid integer(10),empname varchar(50),empsal integer(10))");
        System.out.println("table has been created.....");
        c1 = myDatabase.rawQuery("select * from " + Table_Name, null);
        c1.moveToFirst();
        int count1 = c1.getCount();
        System.out.println("columns --->" + count1);
        if (count1 == 0) {
            myDatabase.execSQL("insert into "+Table_Name+ "(empid,empname,empsal)" +"values(101,'asha',20000)");
            System.out.println("data base has been inserted.....");
        }

        c2 = myDatabase.rawQuery("select * from " + Table_Name, null);
        c2.moveToFirst();
        int count2 = c2.getCount();
        System.out.println("columns --->" + count2);
        final int column1 = c2.getColumnIndex("empid");
        final int column2 = c2.getColumnIndex("empname");
        final int column3 = c2.getColumnIndex("empsal");

        insetbt.setOnClickListener(new View.OnClickListener() {             
            @Override
            public void onClick(View v) {
                if (c2 != null) {
                    do {
                        int id = c2.getInt(column1);
                        String name = c2.getString(column2);
                        int salary = c2.getInt(column3);

                        System.out.println("empID --> "+id);
                        System.out.println("empNAME --> "+name);
                        System.out.println("empsalalry --> "+salary);
                    } while(c2.moveToNext());
                }                                   
            }
        });

        viewbt.setOnClickListener(new View.OnClickListener() {              
            @Override
            public void onClick(View v) {
                try {
                    new ExportDatabaseCSVTask().execute("");
                } catch(Exception ex) {
                    Log.e("Error in MainActivity",ex.toString());
                }
            }
        });
    }
    catch(SQLException ex) { ex.printStackTrace(); }
  /*finally {
        if (myDB != null) { myDB.close(); }
    }*/
}


public class ExportDatabaseCSVTask extends AsyncTask<String, Void, Boolean> {
    private final ProgressDialog dialog = new ProgressDialog(CSVCreationActivity.this);

    @Override
    protected void onPreExecute() {
        this.dialog.setMessage("Exporting database...");
        this.dialog.show();
    }

    protected Boolean doInBackground(final String... args) {
        File dbFile = getDatabasePath("myDatabase.db");
        System.out.println(dbFile);  // displays the data base path in your logcat 
         File exportDir = new File(Environment.getExternalStorageDirectory(), "");

        if (!exportDir.exists()) { exportDir.mkdirs(); }

        File file = new File(exportDir, "myfile.csv");
        try {
            file.createNewFile();
            CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
            Cursor curCSV = myDatabase.rawQuery("select * from " + Table_Name,null);
            csvWrite.writeNext(curCSV.getColumnNames());
            while(curCSV.moveToNext()) {
                String arrStr[] ={curCSV.getString(0),curCSV.getString(1),curCSV.getString(2)};
                // curCSV.getString(3),curCSV.getString(4)};
                csvWrite.writeNext(arrStr);
            }
            csvWrite.close();
            curCSV.close();
            return true;
        } catch(SQLException sqlEx) {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
            return false;
        } catch (IOException e) {
            Log.e("MainActivity", e.getMessage(), e);
            return false;
        }
    }

    protected void onPostExecute(final Boolean success) {
        if (this.dialog.isShowing()) { this.dialog.dismiss(); }
        if (success) {
            Toast.makeText(CSVCreationActivity.this, "Export successful!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CSVCreationActivity.this, "Export failed", Toast.LENGTH_SHORT).show();
        }
    }
}