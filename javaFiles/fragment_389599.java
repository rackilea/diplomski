private GestureDetector createGestureDetector(Context context) {
    GestureDetector gestureDetectorTemp = new GestureDetector(context, new GestureDetector.OnGestureListener() {
                        //we are creating our gesture detector here
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {  //onTap
            AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            am.playSoundEffect(SoundEffectConstants.CLICK);   //if we tap once, play a click sound 
            return false;
        }
        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float distanceX, float distanceY) {
            return false; //this is the wrong kind of scroll
        }
        @Override
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) { //fling = a single slide
            int dx = (int) (motionEvent2.getX() - motionEvent.getX());   //figure out the distance moved horizontally
            int dy = (int) (motionEvent2.getY() - motionEvent.getY());   //figure out the distance moved vertically

            //if dx > 0, moved forward, if dx < 0, moved backward
            //if dy > 0, moved up, if dy < 0, moved down

            return true;
        }
    });

    return gestureDetectorTemp;
}

@Override
public boolean onGenericMotionEvent(MotionEvent event) {
    if (gestureDetector != null) {
        return gestureDetector.onTouchEvent(event);
    }
    return false;
}