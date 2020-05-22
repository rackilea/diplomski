package com.example.myattendance;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TakeAttend extends Activity {

public Button save_attendance;
public Button cancel;
public ListView take_attend_list;
public TextView textView;
public ArrayList<String> attendList;
DatabaseHandler handler;
MyAdapter adapter;
//ArrayAdapter<String> adapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.take_attend);

    save_attendance = (Button) findViewById(R.id.submit_button);
    cancel = (Button) findViewById(R.id.cancel_button);
    take_attend_list = (ListView) findViewById(R.id.take_attend_list);
    textView = (TextView) findViewById(R.id.layout_textview);

    handler = new DatabaseHandler(getApplicationContext());

    attendList = new ArrayList<String>();
    attendList = handler.getdata();

    adapter = new MyAdapter(TakeAttend.this,attendList,this); //'this' means context
    take_attend_list.setAdapter(adapter);

    //adapter = new ArrayAdapter<String>(this, 
        //  android.R.layout.simple_list_item_multiple_choice,attendList);

    //take_attend_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    //take_attend_list.setAdapter(adapter);


    save_attendance.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Toast.makeText(TakeAttend.this, "Saved", Toast.LENGTH_LONG).show();
            //adapter.notifyDataSetChanged();
        }
    });


    cancel.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
        Intent intent = new Intent(TakeAttend.this,NextActivity.class);
        startActivity(intent);
        }
    });
}
}`