void increaseVolume() {
    if (volume < 1) {
        volume += 0.01;

        new Handler().postDelayed(new Runnable {
        @Override
        public void run() {
                increaseVolume();
                mp.setVolume(volume);
            }
        }, 100);
    } else {
        volume = 1;
    }
}