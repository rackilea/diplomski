package com.example.touch;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button b1, b2, b3, b4;

    int b1x1, b1x2, b1y1, b1y2;

    private TextView xcordview;
    private TextView ycordview;
    private TextView buttonIndicator;
    private RelativeLayout touchview;
    private static int defaultStates[];
    private Button mLastButton;
    private final static int[] STATE_PRESSED = {
            android.R.attr.state_pressed,
            android.R.attr.state_focused  
                    | android.R.attr.state_enabled };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xcordview = (TextView) findViewById(R.id.textView4);
        ycordview = (TextView) findViewById(R.id.textView3);
        buttonIndicator = (TextView) findViewById(R.id.button_indicator);
        touchview = (RelativeLayout) findViewById(R.id.relativelayout);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        defaultStates = b1.getBackground().getState();

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        touchview.setOnTouchListener(new View.OnTouchListener() {

            private boolean isInside = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();

                xcordview.setText(String.valueOf(x));
                ycordview.setText(String.valueOf(y));

                for (int i = 0; i < touchview.getChildCount(); i++) {
                    View current = touchview.getChildAt(i);
                    if (current instanceof Button) {
                        Button b = (Button) current;

                        if (!isPointWithin(x, y, b.getLeft(), b.getRight(), b.getTop(),
                                b.getBottom())) {
                            b.getBackground().setState(defaultStates);
                        }

                        if (isPointWithin(x, y, b.getLeft(), b.getRight(), b.getTop(),
                                b.getBottom())) {
                            b.getBackground().setState(STATE_PRESSED);
                            if (b != mLastButton) {
                                mLastButton = b;
                                buttonIndicator.setText(mLastButton.getText());
                            }
                        }

                    }
                }
                return true;
            }

        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
    }

    static boolean isPointWithin(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }
}