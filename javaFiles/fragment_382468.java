VideoView videoView = (VideoView) findViewById(R.id.videoView);
//Use a media controller so that you can scroll the video contents
//and also to pause, start the video.
MediaController mediaController = new MediaController(this); 
mediaController.setAnchorView(videoView);
videoView.setMediaController(mediaController);
videoView.setVideoURI(Uri.parse(videoUrl));
videoView.start();