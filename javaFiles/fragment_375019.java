package com.andruid.magic.imagesegmentationlib;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.*;
import android.os.Bundle;
import android.view.*;
import android.util.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    TextureView textureView;
    ImageButton imageButton, singleImageButton;
    TextView ISOText;
    SeekBar seekBar;
    Integer maxISO, minISO, progress, ISO, width, height, ISO2, ISO3, ISO4, ISORange, ISO5;
    Range<Integer> rangeISO;
    String cameraId="0";
    Button ISOButton, isomin, iso2, iso3, iso4, iso5, isomax;
    boolean focusable = true;
    View popupView;
    LayoutInflater inflater, inflater2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = inflater.inflate(R.layout.activity_main, null);
                width = LinearLayout.LayoutParams.WRAP_CONTENT;
                height = LinearLayout.LayoutParams.WRAP_CONTENT;
                focusable = true;
                final PopupWindow popupwindow = new PopupWindow(popupView, width, height, focusable);

                popupwindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupwindow.dismiss();
                        return true;
                    }
                });

            }

        });
       /* CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        try {
            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraId);
            maxISO = rangeISO.getUpper();
            minISO = rangeISO.getLower();
            rangeISO = characteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
            Range<Long> exposureTimeRange = characteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        ISORange = maxISO - minISO;
        ISO2 = minISO + (ISORange/5);
        ISO3 = minISO + (ISORange/5*2);
        ISO4 = minISO + (ISORange/5*3);
        ISO5 = minISO + (ISORange/5*4);
        isomin.setText(minISO);
        iso2.setText(ISO2);
        iso3.setText(ISO3);
        iso4.setText(ISO4);
        iso5.setText(ISO5);
        isomax.setText(maxISO);
*/
        ISOButton = findViewById(R.id.ISOButton);
        ISOButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inflater2 = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = inflater2.inflate(R.layout.isochanger, null);
                width = LinearLayout.LayoutParams.WRAP_CONTENT;
                height = LinearLayout.LayoutParams.WRAP_CONTENT;
                Log.d("TAG",""+width);
                final PopupWindow popupwindow = new PopupWindow(popupView, width, height, focusable);
                popupwindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupwindow.dismiss();
                        return true;
                    }
                });

            }
        });

    }

}