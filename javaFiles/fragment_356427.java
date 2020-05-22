package com.example.miraapp;


import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class GUI extends Activity implements OnClickListener{

    ImageButton IB1;
    ImageButton IB2;
    ImageButton IB3;
    ImageButton IB4;
    public URI[] urls;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui);

        IB1 = (ImageButton) findViewById(R.id.imageButton1);
        IB1.setOnClickListener(this);

        IB2 = (ImageButton) findViewById(R.id.imageButton2);
        IB2.setOnClickListener(this);

        IB3 = (ImageButton) findViewById(R.id.imageButton3);
        IB3.setOnClickListener(this);

        IB4 = (ImageButton) findViewById(R.id.imageButton4);
        IB4.setOnClickListener(this);


    }
    class RequestTask extends AsyncTask<String, Void, Void>{

        Exception error;
        @Override
        protected Void doInBackground(String... params) {


            String url = params[0];
            // Create a new HttpClient and Post Header
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);

            try {

                // Execute HTTP Post Request
                httpclient.execute(httppost);

            } catch (ClientProtocolException e) {
                error = e;
            } catch (IOException e) {
                error = e;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            if(error != null){
                // TODO handle the exception here, for example:
                Toast.makeText(GUI.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void ibutton4Click()
    {
        new RequestTask().execute("10.0.0.1/cgi-bin/ForwardPress.cgi");
        Toast.makeText(GUI.this, "Forward!", Toast.LENGTH_SHORT).show();
    }
    public void ibuttonRelease()
    {
        new RequestTask().execute("10.0.0.1/cgi-bin/ButtonRelease.cgi");
    }
    public void ibutton2Click()
    {
        new RequestTask().execute("10.0.0.1/cgi-bin/BackwardPress.cgi");
        Toast.makeText(GUI.this, "Backward!", Toast.LENGTH_SHORT).show();
    }
    public void ibutton3Click()
    {
        new RequestTask().execute("10.0.0.1/cgi-bin/RightPress.cgi");
        Toast.makeText(GUI.this, "Turn Right!", Toast.LENGTH_SHORT).show();
    }
    public void ibutton1Click()
    {
        new RequestTask().execute("10.0.0.1/cgi-bin/LeftPress.cgi");
        Toast.makeText(GUI.this, "Turn Left!", Toast.LENGTH_SHORT).show();
    }



    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.imageButton1:

                ibutton1Click();
                break;

            case R.id.imageButton2:

                ibutton2Click();
                break;

            case R.id.imageButton3:

                ibutton3Click();
                break;

            case R.id.imageButton4:

                ibutton4Click();
                break;


        }
    }
}