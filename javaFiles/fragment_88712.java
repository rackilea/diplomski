public void play(final Context c, ArrayList<String> songTitles) {
    stop();
    if (songTitles != null && songTitles.size > 0) {
        final List<String> playList = new ArrayList<String>(songTitles);

        String song = playList.get(0);
        playList.remove(0);

        mSongPlayer = MediaPlayer.create(c, getSongResourceId(song));

        mSongPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (mp == mSongPlayer) {
                    mSongPlayer.start();
                }
            }
        });

        mSongPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
                // Recursively call the play() method with one less
                // track in the list.
                play(c, playList);
            }
        });
    } 
} 

public int getSongResourceId(String songTitle) {
    if (song.equalsIgnoreCase("shakeItOff")){
        return R.raw.shaketoff;
    } else if (song.equalsIgnoreCase("dropItLow")){
        return R.raw.dropitlow;
    } else if (song.equalsIgnoreCase("chachaslide")){
        return R.raw.chachaslide;
    }
}