@Override
    protected void onPause() {
        super.onPause();

        if (myPlayer != null) {
            myPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (myPlayer != null) {
            myPlayer.start();
        }
    }