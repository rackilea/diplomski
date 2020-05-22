File n  = new File(getApplicationContext().getFilesDir()+"/Downloads/video9.mp4");
        Log.e(TAG, "URL:" + n); 
        Log.e(TAG, "exists: " + n.exists());

        fullscreenVideoView.videoFile(n).enableAutoStart().fastForwardSeconds(5)
                .rewindSeconds(5)
                .addSeekBackwardButton()
                .addSeekForwardButton();