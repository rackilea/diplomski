private BroadcastReceiver StateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String status = intent.getStringExtra("status");
            if (parseInt(String.valueOf(status)) == 0) {
                player.stop();
            } else {
                player = MediaPlayer.create(this, R.raw.music);
                player.setLooping(true);
                player.start();
            }

        }
    };