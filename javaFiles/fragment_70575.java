package com.exercise.AndroidListPreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidListPreference extends Activity {

 TextView myListPref;

   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       myListPref = (TextView)findViewById(R.id.list_pref);
       Button buttonSetPreference = (Button)findViewById(R.id.setpreference);

       buttonSetPreference.setOnClickListener(new Button.OnClickListener(){

   @Override
   public void onClick(View v) {
    // TODO Auto-generated method stub
    startActivity(new Intent(AndroidListPreference.this, SetPreferences.class));
   }});
   }

 @Override
 protected void onResume() {
  // TODO Auto-generated method stub
  super.onResume();
  Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
  SharedPreferences myPreference=PreferenceManager.getDefaultSharedPreferences(this);
  String myListPreference = myPreference.getString("listPref", "default choice");
  myListPref.setText(myListPreference);
 }
}