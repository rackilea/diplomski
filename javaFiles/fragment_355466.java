private BroadcastReceiver StateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String status = intent.getStringExtra("status");
            if (parseInt(String.valueOf(status)) == 0) {
                player.pause();  //When app is in background and not killed, we just want to pause the player and not want to lose the current state.
            } else if (parseInt(String.valueOf(status)) == 1) {
                if (player != null)
                    player.start();  // If the player was created and wasn't stopped, it won't be null, and the playback will be resumed from where we left of.
                else {
                    // If the player was stopped, we need to prepare it once again.
                    player = MediaPlayer.create(this, R.raw.music);
                    player.setLooping(true);
                    player.start();
                }
            } else if(player != null){
                player.stop();
                player.release();
            }

        }
    };