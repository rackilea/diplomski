mCurrRotation %= 360;
float fromRotation = mCurrRotation;
float toRotation = mCurrRotation += 90;

final RotateAnimation rotateAnim = new RotateAnimation(
        fromRotation, toRotation, imageview.getWidth()/2, imageView.getHeight()/2);

rotateAnim.setDuration(1000); // Use 0 ms to rotate instantly 
rotateAnim.setFillAfter(true); // Must be true or the animation will reset

imageView.startAnimation(rotateAnim);