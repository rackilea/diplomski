if (getAudioFormat().equals(".mp3")) {
    audioStream = AudioSystem.getAudioInputStream(file); // Obtains an audio input stream of the song
            }
else if (getAudioFormat().equals(".m4a")){
    audioStream = new AACAudioFileReader().getAudioInputStream(file);
            }