public void sorea (View v){
    Button button = (Button) findViewById(R.id.Sorea);
    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

    stopPlayer(); // Call StopPlayer here 

    button.startAnimation(myAnim);
    if (player == null){
        player = MediaPlayer.create(this, R.raw.sorea);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlayer();
            }
        });
    }
    player.start();
}