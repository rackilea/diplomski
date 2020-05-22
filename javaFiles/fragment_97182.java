package com.test; 

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class AsyncTaskActivity extends Activity {
    Button btn;
    /** Called when the activity is first created. */ 
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener((OnClickListener) this);
    } 

    public void onClick(View view){
        new LongOperation().execute("");
    } 

    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override 
        protected String doInBackground(String... params) {
            for(int i=0;i<5;i++) {
                try { 
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block 
                    e.printStackTrace();
                } 
            } 

            return null; 
        } 

        @Override 
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.output);
            txt.setText("Executed");
        } 

        @Override 
        protected void onPreExecute() { 
        } 

        @Override 
        protected void onProgressUpdate(Void... values) {
        } 
    } 
}