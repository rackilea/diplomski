String mrl = "dvb-t://frequency=570000000";
String[] options = {
    ":bandwidth=8",
    ":dvb-adapter=0",
    ":live-caching=1000",
    ":program=16"
};
mediaPlayer.playMedia(mrl, options);