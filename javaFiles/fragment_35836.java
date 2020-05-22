VideoView vv = (VideoView) findViewById(R.id.videoView1);
uri = "your video uri";
vv.setVideoURI(Uri.parse(uri));
vv.start();

vv.setOnCompletionListener(new OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
           finish();
  }
});