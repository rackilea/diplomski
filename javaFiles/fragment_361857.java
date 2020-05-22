@Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                Toast.makeText(this, "FOCUS LOSS TRANSIENT", Toast.LENGTH_SHORT).show();
                pause();
                break;
            case AudioManager.AUDIOFOCUS_LOSS:
                pause();
                Toast.makeText(this, "FOCUS LOST", Toast.LENGTH_SHORT).show();
                break;
            case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                Intent i = new Intent("com.android.music.musicservicecommand");
                i.putExtra("command", "pause");
                MainActivity.this.sendBroadcast(i);
                AM.setStreamVolume(AudioManager.STREAM_MUSIC, AM.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                play();
            case AudioManager.AUDIOFOCUS_REQUEST_FAILED:
                stop();
                break;
            case AudioManager.AUDIOFOCUS_REQUEST_GRANTED:
                Intent iARG = new Intent("com.android.music.musicservicecommand");
                iARG.putExtra("command", "pause");
                MainActivity.this.sendBroadcast(iARG);
                AM.setStreamVolume(AudioManager.STREAM_MUSIC, AM.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                play();
                break;
        }
    }