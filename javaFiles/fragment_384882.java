AudioInputStream ais = 
     AudioSystem.getAudioInputStream(getClass().getResource("/information.wav"));
Clip clip = AudioSystem.getClip();
clip.open(ais);
clip.start();            
JOptionPane.showMessageDialog(...);
clip.close();