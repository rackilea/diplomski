void playSound() {
    System.out.println("+++ PLAY ");

    //if audioTrack has been initialised, first, release any resources
    //then null it
    if (audioTrack != null) {
        audioTrack.release();
        audioTrack = null;
    }

    //now create it again, note: use global audioTrack,
    //that means remove "final AudioTrack" here
    audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, sampleRate, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, generatedSnd.length, AudioTrack.MODE_STATIC);

    audioTrack.write(generatedSnd, 0, generatedSnd.length);
    audioTrack.play();
}