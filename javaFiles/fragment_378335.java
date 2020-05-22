//Create an AudioManager 
    AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//Increase the volume
    audio.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
//Decrease the volume
    audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);