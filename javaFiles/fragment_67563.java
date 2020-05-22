else if (!mediaPlayer.isPlaying()){
    // this is called nowMusicPosition, down there you've used pauseCurrentPosition
    // this always gets 0, never changes
    int nowMusicPosition = 0;
    if (nowMusicPosition == mediaPlayer.getCurrentPosition()){
         // now you're recreating the MediaPlayer. why?
        mediaPlayer = MediaPlayer.create(this, R.raw.ennasona);
        mediaPlayer.start();
    } else {
        // if video at its end gets stopped, the
        // getCurrentPosition() delivers the last
        // position in the video and you get down
        // here and you're seeking to the paused
        // position again
        mediaPlayer.seekTo(pauseCurrentPosition);
        mediaPlayer.start();
        // now you're setting nowMusicPosition, but it gets 0 again if pressing play again, see above
        nowMusicPosition = mediaPlayer.getCurrentPosition();
    }
}