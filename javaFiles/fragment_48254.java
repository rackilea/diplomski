package org.me.rapidchange;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity implements OnKeyListener, 
        OnTouchListener, OnClickListener {
    private class UpdateCounterTask implements Runnable {
        private boolean mInc;

        public UpdateCounterTask(boolean inc) {
            mInc = inc;
        }

        public void run() {
            if (mInc) {
                mHandler.sendEmptyMessage(MSG_INC);
            } else {
                mHandler.sendEmptyMessage(MSG_DEC);
            }
        }
    }

    private static final int MSG_INC = 0;
    private static final int MSG_DEC = 1;

    private Button mIncButton;
    private Button mDecButton;
    private TextView mText;
    private int mCounter;

    private Handler mHandler;
    private ScheduledExecutorService mUpdater;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MSG_INC:
                        inc();
                        return;
                    case MSG_DEC:
                        dec();
                        return;
                }
                super.handleMessage(msg);
            }
        };
        mIncButton = (Button) findViewById(R.id.inc_button);
        mDecButton = (Button) findViewById(R.id.dec_button);
        mText = (TextView) findViewById(R.id.text);
        mIncButton.setOnTouchListener(this);
        mIncButton.setOnKeyListener(this);
        mIncButton.setOnClickListener(this);
        mDecButton.setOnTouchListener(this);
        mDecButton.setOnKeyListener(this);
        mDecButton.setOnClickListener(this);
    }

    private void inc() {
        mCounter++;
        mText.setText(Integer.toString(mCounter));
    }

    private void dec() {
        mCounter--;
        mText.setText(Integer.toString(mCounter));
    }

    private void startUpdating(boolean inc) {
        if (mUpdater != null) {
            Log.e(getClass().getSimpleName(), "Another executor is still active");
            return;
        }
        mUpdater = Executors.newSingleThreadScheduledExecutor();
        mUpdater.scheduleAtFixedRate(new UpdateCounterTask(inc), 200, 200,
                TimeUnit.MILLISECONDS);
    }

    private void stopUpdating() {
        mUpdater.shutdownNow();
        mUpdater = null;
    }

    public void onClick(View v) {
        if (mUpdater == null) {
            if (v == mIncButton) {
                inc();
            } else {
                dec();
            }
        }
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        boolean isKeyOfInterest = keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER;
        boolean isReleased = event.getAction() == KeyEvent.ACTION_UP;
        boolean isPressed = event.getAction() == KeyEvent.ACTION_DOWN
                && event.getAction() != KeyEvent.ACTION_MULTIPLE;

        if (isKeyOfInterest && isReleased) {
            stopUpdating();
        } else if (isKeyOfInterest && isPressed) {
            startUpdating(v == mIncButton);
        }
        return false;
    }

    public boolean onTouch(View v, MotionEvent event) {
        boolean isReleased = event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL;
        boolean isPressed = event.getAction() == MotionEvent.ACTION_DOWN;

        if (isReleased) {
            stopUpdating();
        } else if (isPressed) {
            startUpdating(v == mIncButton);
        }
        return false;
    }
}