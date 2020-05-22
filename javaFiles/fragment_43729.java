import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

public class HBFloatingHead extends Service {

    private WindowManager mhbWindow;
    private TextView mfloatingHead;
    private Intent intent;
    public static final String BROADCAST_ACTION = "com.fragmentsample";


    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        HBFloatingHead getService() {
            return HBFloatingHead.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mfloatingHead != null) {
            mhbWindow.removeView(mfloatingHead);
            countDownTimer.cancel();
        }
    }

    WindowManager.LayoutParams params;

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent(BROADCAST_ACTION);

        mhbWindow = (WindowManager) getSystemService(WINDOW_SERVICE);
        mfloatingHead = new TextView(this);
        mfloatingHead.setBackgroundResource(R.drawable.floating4);
        mfloatingHead.setTextColor(Color.WHITE);
        mfloatingHead.setTextSize(20f);
        mfloatingHead.setHint("00.00 sec");
        mfloatingHead.setGravity(Gravity.CENTER);
        mfloatingHead.setPadding(20, 20, 20, 20);

        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;

        mhbWindow.addView(mfloatingHead, params);

        try {
            mfloatingHead.setOnTouchListener(new View.OnTouchListener() {

                private WindowManager.LayoutParams paramsF = params;
                private int initialX;
                private int initialY;
                private float initialTouchX;
                private float initialTouchY;

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:

                            break;

                        case MotionEvent.ACTION_DOWN:

                            initialX = paramsF.x;
                            initialY = paramsF.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();

                            break;

                        case MotionEvent.ACTION_MOVE:

                            paramsF.x = initialX
                                    + (int) (event.getRawX() - initialTouchX);
                            paramsF.y = initialY
                                    + (int) (event.getRawY() - initialTouchY);
                            mhbWindow.updateViewLayout(mfloatingHead, paramsF);

                            break;
                        default:
                            break;
                    }

                    return false;
                }
            });
        } catch (Exception e) {
            Log.e("#HB#", e.getMessage().toString());
        }

        mfloatingHead.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                //HBFloatingHead.this.stopSelf();


            }
        });
        startTimer(1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;
    }

    android.os.Handler handler = new android.os.Handler(new android.os.Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            try {
                long seconds = msg.what;
                String text = String.format("%02d", seconds / 60) + ":"
                        + String.format("%02d", seconds % 60);
                Log.e("TAG", "Updated text : " + text);
                mfloatingHead.setText(text);
                mhbWindow.updateViewLayout(mfloatingHead, params);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    });

    CountDownTimer countDownTimer;

    private void startTimer(final int minuti) {
        countDownTimer = new CountDownTimer(60 * minuti * 1000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);

                if (seconds > 0)
                    handler.sendEmptyMessage(seconds);
                else
                    HBFloatingHead.this.stopSelf();

//              Log.d("TIME", mTvTime.getText().toString());
            }

            @Override
            public void onFinish() {

            }
        };

        countDownTimer.start();
    }
}