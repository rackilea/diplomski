mMediaPlayer = new MediaPlayer();

    mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                        mMediaPlayer.setDataSource(url);

    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                     mMediaPlayer.start();
                }
            });

    mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                            @Override
                                            public boolean 
    onError(MediaPlayer mp, int what, int extra) {

                                                return false;
                                            }
                                        });

        mMediaPlayer.prepareAsync();
                                    } catch (IOException e) {
                                      nowplaying.setText("OFFLINE")
                                        e.printStackTrace();
                                    }