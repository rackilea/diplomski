public void playMusic() {
    if(test.equalsIgnoreCase("Jason Mraz")) {
        mySong = MediaPlayer.create(MusicClass.this, jm[musicCounter]);
        displaySong(jm);
        songNumbers = jm.length;
    }else if(test.equalsIgnoreCase("fob")) {
        mySong = MediaPlayer.create(MusicClass.this, fob[musicCounter]);
        displaySong(fob);
        songNumbers = fob.length;
    }else if(test.equalsIgnoreCase("ed")) {
        mySong = MediaPlayer.create(MusicClass.this, ed[musicCounter]);
        displaySong(ed);
        songNumbers = ed.length;
    }
    mySong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
           nextSong();
        }
    });
    mySong.start();
}