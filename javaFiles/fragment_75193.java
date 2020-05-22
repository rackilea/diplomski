import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class TextViewPinchZoom extends Activity implements OnTouchListener {

final static float STEP = 200;
TextView mytv;
float mRatio = 1.0f;
int mBaseDist;
float mBaseRatio;
float fontsize = 13;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mytv = (TextView) findViewById(R.id.mytv);
    mytv.setTextSize(mRatio + 13);
   }

  public boolean onTouchEvent(MotionEvent event) {
    if (event.getPointerCount() == 2) {
        int action = event.getAction();
        int pureaction = action & MotionEvent.ACTION_MASK;
        if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
            mBaseDist = getDistance(event);
            mBaseRatio = mRatio;
        } else {
            float delta = (getDistance(event) - mBaseDist) / STEP;
            float multi = (float) Math.pow(2, delta);
            mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
            mytv.setTextSize(mRatio + 13);
        }
    }
    return true;
    }

    int getDistance(MotionEvent event) {
    int dx = (int) (event.getX(0) - event.getX(1));
    int dy = (int) (event.getY(0) - event.getY(1));
    return (int) (Math.sqrt(dx * dx + dy * dy));
   }

  public boolean onTouch(View v, MotionEvent event) {
    return false;
  }
}