private void startPlaying(boolean startFromCurrent) { 
    runOnUiThread(new Runnable(){
        @Override
        public void run(){  
            videoView.stopPlayback();
            videoView.setVideoURI(uri1);
        }
    });
...