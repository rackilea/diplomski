package com.example.prs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PrsActivity extends Activity {

    private TextView title;
    private String url = "http://www.google.com";
    private String pageHtml;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prs);
        title = (TextView) findViewById(R.id.title);
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = client.execute(request); // asks to add
                                                                // try/catch
                                                                // block here

            String html = "";
            InputStream in = response.getEntity().getContent(); // asks to add
                                                                // try/catch
                                                                // block here
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in));
            StringBuilder str = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) // asks to add try/catch
                                                        // block here
            {
                str.append(line);
            }
            in.close(); // asks to add try/catch block here
            html = str.toString();
        } catch (IOException err) {
            Log.e(PrsActivity.class.getSimpleName(), err.toString(), err);
        }
    }
}