File file = new File(System.getProperty("user.dir") + "/assets/sounds/" + this.firePath);
AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

AudioFormat format = audioStream.getFormat();
DataLine.Info info = new DataLine.Info(Clip.class, format);
Clip audioClip = (Clip) AudioSystem.getLine(info);

audioClip.open(audioStream);
audioClip.start();