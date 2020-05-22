public class MyView extends View {

GestureDetector gestureDetector;

public MyView(Context context, AttributeSet attrs) {
    super(context, attrs);
            // creating new gesture detector
    gestureDetector = new GestureDetector(context, new GestureListener());
}

// skipping measure calculation and drawing

    // delegate the event to the gesture detector
@Override
public boolean onTouchEvent(MotionEvent e) {
    return gestureDetector.onTouchEvent(e);
}


private class GestureListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }
    // event when double tap occurs
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

        return true;
    }
}
}