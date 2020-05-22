private int swipeCounter = 0;

@Override
public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            x1 = event.getX();
            break;
        case MotionEvent.ACTION_UP:
            x2 = event.getX();
            float deltaX = x2 - x1;

            boolean left = Math.abs(deltaX) > MIN_DISTANCE;

            swipeCounter++;

            switch(swipeCounter) {
                case 1:
                    ...
                    break;
                case 2:
                    ...
                    break;
            }
            break;
    }
    return super.onTouchEvent(event);
}