@Override
    public void onCompletion(MediaPlayer mp) {
        if (mediaPlayer != null) {
            mp.stop();
            mp.release();
        }
    }