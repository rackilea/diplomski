private class EyeGestureListener implements Listener {

    @Override
    public void onEnableStateChange(EyeGesture eyeGesture, boolean paramBoolean) {

    }

    @Override
    public void onDetected(final EyeGesture eyeGesture) {
       //Show what we just detected
       Log.i(eyeGesture.toString() , " is detected");

              //Check which eye event occured
        if (eyeGesture.name() == target1.name()) {
            // Wink
            Log.i("EyeGesture: ", " you just winked");
        } else if (eyeGesture.name() == target2.name()) {
            // Double blink
            Log.i("EyeGesture: ", " you just double winked");
        } else if (eyeGesture.name() == target3.name()) {
            // Look at Screen
            Log.i("EyeGesture: ", " you Looked at Screen");
        }

    }
}