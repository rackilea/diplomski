package com.example.accelerometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class AccelerometerActivity extends Activity implements
SensorEventListener {    
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView title;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        title = (TextView) findViewById(R.id.txt);
        iv = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        if (Math.abs(x) > Math.abs(y)) {
            if (x < 0) {
                iv.setImageResource(R.drawable.cartoonright);
            }
            if (x > 0) {
                iv.setImageResource(R.drawable.cartoonleft);
            }
        } else {
            if (y < 0) {
                iv.setImageResource(R.drawable.cartoontop);
            }
            if (y > 0) {
                iv.setImageResource(R.drawable.ic_launcher);
            }
        }
        if (x > (-2) && x < (2) && y > (-2) && y < (2)) {
            iv.setImageResource(R.drawable.cartooncenter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.accelerometer, menu);
        return true;
    }
}