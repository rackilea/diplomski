switch (eventPadTouch) {

    case MotionEvent.ACTION_DOWN:
        // start playing sound , in your case:
        policeSound.start();
        policeSounds.setPressed(true)
        return true;


    case MotionEvent.ACTION_UP:
        // stop playing sound , in your case:
        policeSound.pause();
        policeSounds.setPressed(false)
        return true;

}