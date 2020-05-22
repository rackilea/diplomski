boolean isPlay = true;

final ImageView playButton = (ImageView) findViewById(R.id.playbutton);
playButton.setOnClickListener(new OnClickListener() {

    public void onClick(View v) {
        if(isPlay)
            playButton.setImageResource(R.drawable.stopicon);
        else
            playButton.setImageResource(R.drawable.playicon);
        isPlay = !isPlay;
    }

});