public void playSound(String soundFile) {
        try {

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(this.getClass().getResource("/Sounds/" + soundFile));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
             e.printStackTrace();
          } catch (IOException e) {
             e.printStackTrace();
          } catch (LineUnavailableException e) {
             e.printStackTrace();
          }
    }