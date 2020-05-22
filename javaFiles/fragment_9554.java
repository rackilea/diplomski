MediaPlayer soundOne = null;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    ....
    play_SoundOne.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            soundOne.start();
        }
    });
}

@Override
protected void onStart() {
    super.onStart();
    if(soundOne == null){
         soundOne = MediaPlayer.create(this, R.raw.somesound);
         soundOne.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                //Don't reset
            }

        });
    }
}

@Override
protected void onStop() {
    super.onStop();
    soundOne.release();
    soundOne = null;
}