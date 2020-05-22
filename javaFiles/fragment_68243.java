switch (event.getAction()) {    
    case MotionEvent.ACTION_DOWN:
        // reset the touched quadrants
        for (int i = 0; i < quadrantTouched.length; i++) {
            quadrantTouched[i] = false;
        }
        allowRotating = false;
        startAngle = getAngle(event.getX(), event.getY());
        break;
    case MotionEvent.ACTION_MOVE:
        double currentAngle = getAngle(event.getX(), event.getY());
        rotateDialer((float) (startAngle - currentAngle));
        startAngle = currentAngle;
        break;
    case MotionEvent.ACTION_UP:
        allowRotating = true;
        break;
}

// set the touched quadrant to true
quadrantTouched[getQuadrant(event.getX() - (dialerWidth / 2), dialerHeight - event.getY() - (dialerHeight / 2))] = true;
detector.onTouchEvent(event);
return true;