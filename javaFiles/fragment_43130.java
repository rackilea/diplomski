package com.example.cliente.myapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView backgroundImage, upImage, downImage, leftImage, alertImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundImage = findViewById(R.id.background_image);
        Picasso.get().load(R.drawable.background).into(backgroundImage);

        upImage = findViewById(R.id.up_arrow_image);
        Picasso.get().load(R.drawable.up).into(upImage);

        downImage = findViewById(R.id.down_arrow_image);
        Picasso.get().load(R.drawable.down).into(downImage);

        leftImage = findViewById(R.id.left_arrow_image);
        Picasso.get().load(R.drawable.left).into(leftImage);

        alertImage = findViewById(R.id.alert_image);
        Picasso.get().load(R.drawable.alert).into(alertImage);
    }
}