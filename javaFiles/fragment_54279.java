private Runnable VolumeFadeRunnable = new Runnable() {
        @Override
        public void run() {
                volume--;
             player.setVolume(volume, volume);
                 if(volume>0)
               handler.postDelayed(this, 1000);
                 else
                   handler.removeCallbacks(this);
        }
    };