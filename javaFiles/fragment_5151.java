one.start();
one.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
          one.setDataSource(loopthroughSources); //may be an array or list of files path
          one.start();
        }
    });
    }
});