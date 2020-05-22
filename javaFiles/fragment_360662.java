package com.example.animation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class view_rooms extends AppCompatActivity {
    ListView listView;
    String mTitle[]={"Room1","Room2","Room3","Room4","Room5"};
    String mDescription[]={"Access Room1","Access Room2","Access Room3","Access Room4","Access Room5"};
    int images[]={R.drawable.lights_open,R.drawable.lights_open,R.drawable.lights_open,R.drawable.lights_open,R.drawable.lights_open};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rooms);
        listView=findViewById(R.id.list_view_id);

    }