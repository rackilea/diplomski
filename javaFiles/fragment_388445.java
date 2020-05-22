private OnClickListener btnMercyListener = new OnClickListener()
{
    public void onClick(View v)
    {
        if(isPressed)
        {
            return;
        }

        isPressed = true;

        // create your media player
        mp = MediaPlayer.create(iMEvil.this,R.raw.mercy); 

        // set your listener
        mp.setOnCompletionListener(mp.setOnCompletionListener(new OnCompletionListener(){ 

            // @Override 
            public void onCompletion(MediaPlayer arg0) {
                    if(!isPressed)
                    {
                        return;
                    }

                    isPressed = false;

                    // re-enable your play button
                    playButton.enable();

                    // disable the pause button
                    pauseButton.disable();

                    mp.release();
                    mp.prepare();
                } 
            }
        );

        // disable the play button
        playButton.disable();

        // enable the pause button
        pauseButton.enable();

        // start playback
        mp.start();
    }
};