try 
{
    player.reset();
    player.setDataSource(getApplicationContext(), trackUri);
    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
    player.prepareAsync();
}