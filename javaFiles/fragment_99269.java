package com.example.galaxydefense;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button buttonplay=(Button)findViewById(R.id.buttonplay);
    Button buttonhelp=(Button)findViewById(R.id.buttonhelp);
    Button buttoncredits=(Button)findViewById(R.id.buttoncredits);
    buttonplay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Thread play=new Thread() {
                @Override
                public void run() {
                    try {
                        Intent play=new Intent("android.intent.action.PLAY");
                        startActivity(play);
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        finish();
                    }
                }
            };
        }
    });
    buttonhelp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Thread help=new Thread() {
                @Override
                public void run() {
                    try {
                        Intent help=new Intent("android.intent.action.HELP");
                        startActivity(help);
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        finish();
                    }
                }
            };
        }
    }
    );
    buttoncredits.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Thread credits=new Thread() {
                @Override
                public void run() {
                    try {
                        Intent credits=new Intent("android.intent.action.CREDITS");
                        startActivity(credits);
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        finish();
                    }
                }
            };
        }
    }
    );
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}
}