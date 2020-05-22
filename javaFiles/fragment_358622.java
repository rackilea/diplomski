package com.square.changecolortwotimes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout changingColorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        changingColorLayout = (LinearLayout)findViewById(R.id.changingcolorlayout);


        ValueAnimator colorAnim = ObjectAnimator.ofInt(changingColorLayout, "backgroundColor", Color.BLUE, Color.GREEN);

        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();
    }
}