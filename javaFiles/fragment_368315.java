@Override
public boolean onScale(ScaleGestureDetector detector) {
    if (gestureTolerance(detector)) {
        if (mScaleListener != null) {
            float scaleFactor = detector.getScaleFactor();
            if (scaleFactor > 1F) {
                mScaleListener.onScaleUp(scaleFactor);
                mInitialDistance = detector.getCurrentSpan();
            } else if (scaleFactor < 1F) {
                mScaleListener.onScaleDown(scaleFactor);
                mInitialDistance = detector.getCurrentSpan();
            }
        }
    }
    return true;
}

private boolean gestureTolerance(@NonNull ScaleGestureDetector detector) {
    final float currentDistance = detector.getCurrentSpan();
    final float distanceDelta = Math.abs(mInitialDistance - currentDistance);
    return distanceDelta > mScaleTriggerDistance;
}