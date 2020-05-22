MediaPlayer mp = null;

public void next (View view) {
    if (mp != null) {
        mp.stop();
        mp.release();
    }
    mp = MediaPlayer.create(this, R.raw.dry);
    mp.start();
}