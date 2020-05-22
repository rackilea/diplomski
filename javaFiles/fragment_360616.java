package com.douglasdrumond.leaky;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static Drawable sBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView label = new TextView(this);
        System.gc();
        long memory = Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory();
        label.setText("Memory: " + memory / 1024f);

        if (sBackground == null) {
            sBackground = getResources().getDrawable(R.drawable.large_bitmap);
        }
        label.setBackgroundDrawable(sBackground);

        setContentView(label);
    }

}