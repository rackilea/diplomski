package com.example.singleitemlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DisplayActivity extends Activity {

ListView lv;
ArrayList<String> myList;
String myName;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second);

    Intent n = getIntent();
    myName = n.getStringExtra("buffer");

    myList = new ArrayList<String>();

    lv = (ListView) findViewById(R.id.listViewData);

    myList.add(myName);

    lv.setAdapter(new ArrayAdapter<String>(DisplayActivity.this,
            android.R.layout.simple_list_item_1, myList));

}