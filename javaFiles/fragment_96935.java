package com.testapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class HelloNative extends Activity {

    TelephonyManager        tm;
    MyPhoneStateListener    MyListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyListener   = new MyPhoneStateListener();
        tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(MyListener ,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        Button submitButton = new Button(this);
        submitButton.setText("Return to the Web App");
        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);
                finish();
            };
        });

        linearLayout.addView(submitButton);
    }

    private class MyPhoneStateListener extends PhoneStateListener
    {
      /* Get the Signal strength from the provider, each time there is an update */
      @Override
      public void onSignalStrengthsChanged(SignalStrength signalStrength)
      {
         super.onSignalStrengthsChanged(signalStrength);
         Toast.makeText(getApplicationContext(), "Signal strength is: "
            + String.valueOf(signalStrength.getGsmSignalStrength()), Toast.LENGTH_SHORT).show();
      }

    };

}