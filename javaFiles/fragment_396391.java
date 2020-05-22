package com.so.chilledrat.chronoexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class OtherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button switchButton = new Button(this);
        switchButton.setText("Switch Back");
        switchButton.setOnClickListener(mSwitchListener);
        layout.addView(switchButton);

        setContentView(layout);
    }

    View.OnClickListener mSwitchListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // Intent myIntent = new Intent(OtherActivity.this.getBaseContext(),
            // ChronoExampleActivity.class);
            // startActivityForResult(myIntent, 0);
            finish();
        }

    };
}