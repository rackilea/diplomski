package com.example.vitoriano_vaz.eastbayvapes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Uri number = Uri.parse("tel:9259619029");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        Uri webpage = Uri.parse("http://www.facebook.com/eastbayvapes");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        // intent to send user to instagram

        Uri uri = Uri.parse("http://instagram.com/_u/eastbayvapes");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        TextView instaText = (TextView)findViewById(R.id.YOUR_TEXTVIEW_ID);
        instaText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/eastbayvapes")));
            }
        }
    });


        //Intent to send user to email app
      TextView emailText = (TextView)findViewById(R.id.YOUR_TEXTVIEW_ID);
        emailText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"eastbayvapes@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            intent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(intent, ""));
        }
    });


    }
}