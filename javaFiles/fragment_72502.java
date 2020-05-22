package com.example.jsonparser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView mListView;
    private Adapter mAdapter;
    private ArrayList<Data> mSource = new ArrayList<Data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(android.R.id.list);
        mAdapter = new Adapter(this, mSource);
        mListView.setAdapter(mAdapter);
        mListView.setRecyclerListener(mAdapter.mRecyclerListener);

        final String url = "http://metalgearrisingguide.com/samplejson.json";
        new Thread(new Runnable() {

            @Override
            public void run() {
                Parser parser = new Parser(getJSONfromURL(url));
                mSource = parser.getSource();
                Message msg = mHandler.obtainMessage();
                mHandler.sendMessage(msg);

            }
        }).start();

    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            mAdapter.setObjects(mSource);
            mAdapter.notifyDataSetChanged();
        }
    };

    public String getJSONfromURL(String url) {
        InputStream is = null;
        String result = "";

        // http post
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }

        // convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();

        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
        }
        return result;
    }
}