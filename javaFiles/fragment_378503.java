package com.xtensivearts.episode.seven;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Episode7 extends ListActivity {
    String[] mTestArray;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create an ArrayAdapter that will contain all list items
        ArrayAdapter<String> adapter;

        mTestArray = getResources().getStringArray(R.array.testArray);    

        /* Assign the name array to that adapter and 
        also choose a simple layout for the list items */ 
        adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mTestArray);

        // Assign the adapter to this ListActivity
        setListAdapter(adapter);
    }
}