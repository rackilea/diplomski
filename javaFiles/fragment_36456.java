AudioManager amanager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
int maxVolume = amanager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
amanager.setStreamVolume(AudioManager.STREAM_ALARM, maxVolume, 0);

MediaPlayer mediaPlayer= new MediaPlayer();

mediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM); // this is important.

mediaPlayer.setDataSource(context, ringtoneUri);
mediaPlayer.setLooping(looping);  
mediaPlayer.prepare();
mediaPlayer.start();