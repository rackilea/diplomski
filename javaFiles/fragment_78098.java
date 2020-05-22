public void onPress(View view){

    // get the view item's ID which in your case will be the button's id and use a switch case on it

    int id = view.getId()

    switch (id){
        case R.id.button:
            scrubber = (SeekBar)findViewById(R.id.seekBar);
            mplayer = MediaPlayer.create(this, R.raw.house);
            musicPlaying = 1;
            break;

        case R.id.button2:
            scrubber = (SeekBar)findViewById(R.id.seekBar2);
            mplayer = MediaPlayer.create(this, R.raw.techno);
            musicPlaying = 2;
            break;

       case R.id.button3:
            scrubber = (SeekBar)findViewById(R.id.seekBar3);
            mplayer = MediaPlayer.create(this, R.raw.deephouse);
            musicPlaying = 3;
            break;

       case R.id.button4:
            scrubber = (SeekBar)findViewById(R.id.seekBar4);
            mplayer = MediaPlayer.create(this, R.raw.chill);
            musicPlaying = 4;
            break;
    }