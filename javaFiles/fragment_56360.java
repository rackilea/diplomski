player.prepare();
player.setOnCompletionListener(new OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer player) {
        player.stop();
        // next audio file
    }
 });
 player.start();