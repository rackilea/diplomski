package com.t3hh4xx0r.examplecodetestingapp;

import java.security.acl.Group;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends ActionBarActivity {
    List<Group> groupsList = new List<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("groups");

        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> arg0, ParseException e) {
                if (e == null) {
                    for (ParseObject groups : arg0) {
                        Group g = new Group((String) groups.get("groupName"),
                                (String) groups.get("aboutGroup"));
                        groupsList.add(g);
                    }
                    ;
                } else {
                    e.printStackTrace();
                }
            }
        });

    }
}