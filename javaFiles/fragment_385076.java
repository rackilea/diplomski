public void ringAlarm() {

    Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    if (alarmUri == null) {
        alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
    }

    if (alarmUri == null) {
        Log.e("ringAlarm" , "alarmUri null. Unable to get default sound URI");
        return;
    }

    MediaPlayer mp = new MediaPlayer();
    // This is what sets the media type as alarm
    // Thus, the sound will be influenced by alarm volume
    mp.setAudioAttributes(new AudioAttributes.Builder()
                             .setUsage(AudioAttributes.USAGE_ALARM).build());

    try {
        mp.setDataSource(getApplicationContext(), alarmUri);
        mp.prepare();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // To continuously loop the alarm sound
    mp.setLooping(true);
    mp.start();
}