package de.kwietzorek.fulcrumwebview;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String selected;
    Spinner spinner;
    WebView myWebView;

    /* Menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_server:
                Intent intent = new Intent(this, AddIP.class);
                this.startActivity(intent);
                return true;
            case R.id.menu_refresh:
                myWebView.reload();
                return true;
            default:
                return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //WebView
        myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebC());
        WebSettings webSettings = myWebView.getSettings();

        //JavaScript enable
        webSettings.setJavaScriptEnabled(true);

        //Server name spinner
        ArrayList<String> server_name_list = getIntent().getStringArrayListExtra(
                "int_new_server_name");

        if (server_name_list != null) {

        spinner = (Spinner) findViewById(R.id.server_spinner);

        ArrayAdapter<String> server_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, server_name_list);

        server_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(server_adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                selected = parent.getItemAtPosition(pos).toString();

                myWebView.loadUrl(selected);
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }
    }

    //WebVie Client
        public class WebC extends WebViewClient {

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);

        }
    }
}