package com.example.connor.fragmenttestapp;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentDefault fragDefault = new FragmentDefault();
    Fragment1 frag1 = new Fragment1();
    Fragment2 frag2 = new Fragment2();
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragDefault)
                    .commit();
        }
    }

    public void openFrag(View view) {
    fm.beginTransition().replace(R.id.fragment_container, frag1)
        .addToBackStack(null).commit();

    }

    public void openFrag2(View view) {
    fm.beginTransition().replace(R.id.fragment_container, frag2);
        .addToBackStack(null).commit();
    }
}