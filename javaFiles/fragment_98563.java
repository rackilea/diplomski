public static MediaPlayer create(Context context, int musicID) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer.create(context, musicID);
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaPlayer.create(context, musicID);
    }