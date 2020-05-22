//unbind service so the audio continues to play
    private void unbindMediaPlayerService() {
        mediaPlayerService.setCoverArt(coverArt);
        mediaPlayerService.setSelectedMed(selectedMed);

        unbindService(mediaPlayerConnection);
        serviceIsBound = false;
        Log.v(TAG, "Service unbound");
    }