audioSession = new MediaSession(getApplicationContext(), "TAG");
    audioSession.setCallback(new MediaSession.Callback() {

    @Override
    public boolean onMediaButtonEvent(final Intent mediaButtonIntent) {
        String intentAction = mediaButtonIntent.getAction();
        if (Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            KeyEvent event = mediaButtonIntent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);

            if (event != null) {

                stopTimeOfGame_millis = event.getDownTime();
                double usersReactionTime = (event.getDownTime() - startTimeOfGame_millis) / 1000.0;
                UtilsRG.info("event.getDownTime(): " + usersReactionTime);


                double getEventTime = (event.getEventTime() - startTimeOfGame_millis) / 1000.0;
                UtilsRG.info("event.getEventTime(): " + getEventTime);

                int action = event.getAction();
                if (action == KeyEvent.ACTION_DOWN) {
                    long action_down = android.os.SystemClock.uptimeMillis();
                    double actionDown = (action_down - startTimeOfGame_millis) / 1000.0;
                    UtilsRG.info("ACTION_DOWN: " + actionDown);
                }

                if (action == KeyEvent.ACTION_UP) {
                    long action_up = android.os.SystemClock.uptimeMillis();
                    double actionUp = (action_up - startTimeOfGame_millis) / 1000.0;
                    UtilsRG.info("ACTION_UP: " + actionUp);
                }
            }
        }
        return true;
    }


    });

    PlaybackState state = new PlaybackState.Builder()
            .setActions(PlaybackState.ACTION_PLAY_PAUSE)
            .setState(PlaybackState.STATE_PLAYING, 0, 0, 0)
            .build();
    audioSession.setPlaybackState(state);

    audioSession.setFlags(MediaSession.FLAG_HANDLES_MEDIA_BUTTONS | MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS);

    audioSession.setActive(true);