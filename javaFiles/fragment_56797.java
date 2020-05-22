package com.example.dilo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class dilo extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button1main = (Button) findViewById(R.id.Button01main);

        button1main.setOnClickListener(new OnClickListener() {

        @Override

            public void onClick(View v) {

                //set up dialog
                final Dialog dialog = new Dialog(dilo.this);
                dialog.setContentView(R.layout.maindialog);
                dialog.setTitle("This is my custom dialog box");
                dialog.setCancelable(true);
                //there are a lot of settings, for dialog, check them all out!
                //set up text
                TextView text = (TextView) dialog.findViewById(R.id.TextView01);
                text.setText(R.string.lots_of_text);
                //set up image view
                ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
                img.setImageResource(R.drawable.icon);
                //set up button
                Button button = (Button) dialog.findViewById(R.id.Button01);
                button.setOnClickListener(new OnClickListener() {
                @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                //now that the dialog is set up, it's time to show it   
                dialog.show();
            }
        });

   }
}