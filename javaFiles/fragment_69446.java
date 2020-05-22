button_a.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        player= MediaPlayer.create(GameActivity.this, R.raw.a);
        player.start();
        letterTapped = 0;

        // Ignore further clicks
        button_a.setOnClickListener(null);

        // Disable button so the user knows that he can't click again
        button_a.setEnabled(false); 
    }
});