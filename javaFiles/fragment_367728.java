private void readyToPlay(Uri uri) {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.setOnCompletionListener(this);
                mediaPlayer.setDataSource(activity, uri);//Write your location here
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }