AdvancedPlayer p = new AdvancedPlayer(bis)
p.setPlayBackListener(new Playbacklistener(){

    //override unimplemented methods
    @Override
    public void playbackFinished(PlaybackEvent evt){
        p.start()
    }

    @Override
    public void playbackStarted(PlaybackEvent evt){}
};