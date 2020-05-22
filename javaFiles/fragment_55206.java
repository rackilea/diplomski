ParseFile descr = object.getParseFile("audiofile");
                if (descr != null) {
                    String audioFileURL = descr.getUrl();
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    try {
                        mediaPlayer.setDataSource(audioFileURL);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }
                    ...
                    ...