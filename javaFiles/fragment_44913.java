YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);

youTubePlayerView.initialize(new YouTubePlayerInitListener() {
    @Override
    public void onInitSuccess(final YouTubePlayer initializedYouTubePlayer) {    
        initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady() {
                String videoId = "6JYIGclVQdw";
                initializedYouTubePlayer.loadVideo(videoId, 0);
            }
        });        
    }
}, true);