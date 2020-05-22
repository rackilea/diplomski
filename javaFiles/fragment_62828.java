Clip clip = null;

    try {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
        DataLine.Info info = new DataLine.Info(Clip.class, inputStream.getFormat());
        clip = (Clip)AudioSystem.getLine(info);
        clip.open(inputStream);
    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
        Logger.getLogger(Pomodoro.class.getName()).log(Level.SEVERE, null, ex);
    }

    return clip;