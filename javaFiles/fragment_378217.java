private void play(String[] videoUrls, final int current) {
    videoView.setVideoURI(Uri.parse(videoUrls[current]));
    videoView.setMediaController(new MediaController(this));
    videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
            try {
                // try to play video from next video url
                play(videoUrls, current + 1);
            } catch (IndexOutOfBoundsException e) {
                // end is reached
            }
            return false;
        }
    });
    videoView.start();
}