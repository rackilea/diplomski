public class CustomView extends View implements View.OnTouchListener {


float save_x = 0;
float save_y = 0;

@Override
public boolean onTouch(View v, MotionEvent event) {


    if (mSwipeInterface == null)
        return false;

    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        save_x = event.getX();
        save_y = event.getY();
    }
    if (event.getAction() == MotionEvent.ACTION_UP) {
        float difx = event.getX() - save_x;
        float dify = event.getY() - save_y;

        if (IsBigger(difx, dify)) {
            if (difx > -30 && difx < 30)return false;
            if (difx > 0){
                mSwipeInterface.swipe(SwipeEnum.RIGHT);
            }
            else{
                mSwipeInterface.swipe(SwipeEnum.LEFT);
            }
        }
        else{
            if (dify > -30 && dify < 30)return false;
            if (dify > 0){
                mSwipeInterface.swipe(SwipeEnum.DOWN);
            }
            else{
                mSwipeInterface.swipe(SwipeEnum.TOP);
            }
        }


    }
    return true;
}

private boolean IsBigger(float difx, float dify) {
    if (difx < 0) {
        difx *= -1;
    }
    if (dify < 0) {
        dify *= -1;
    }

    if (difx > dify){
        return true;
    }
    return false;
}

public enum SwipeEnum {
    LEFT,
    DOWN,
    RIGHT,
    TOP;
}

interface swipeInterface {
    public void swipe(SwipeEnum swipeEnum);
}

private swipeInterface mSwipeInterface = null;

public void setSwipeListener(swipeInterface swipe) {
    mSwipeInterface = swipe;
}

public CustomView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.setOnTouchListener(this);
}

public CustomView(Context context) {
    super(context);
}
}