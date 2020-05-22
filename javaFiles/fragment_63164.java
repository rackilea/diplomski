@Override
    public void onBackPressed() {
        super.onBackPressed();
       //Here you can stop your MediaPlayer
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }