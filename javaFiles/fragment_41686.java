public class c extends JFrame {

  String f="e-22.wav";
  JButton btnPlaySound=new JButton("Listen");
  Clip clip = null;

public c(){

  btnPlaySound.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            try {
              JButton b=(JButton)arg0.getSource();
              // play the sound clip
              if(b.getText().equals("Listen")){
                b.setText("Stop");
                btnPlaySoundCLick();
              } else if(btnPlaySound.getText().equals("Stop")) {
                  b.setText("Listen");
                  clip.stop();
              }
            } catch (LineUnavailableException | IOException
                    | UnsupportedAudioFileException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });

  setSize(500, 500);
  add(btnPlaySound);
  setVisible(true);

}

 private void btnPlaySoundCLick() throws LineUnavailableException, IOException, UnsupportedAudioFileException{ 

  File soundFile = new File(f);
  AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

  DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
  clip = (Clip) AudioSystem.getLine(info);
  clip.open(sound);

  clip.addLineListener(new LineListener() {
  public void update(LineEvent event) {
    if (event.getType() == LineEvent.Type.STOP) {
    System.out.println("stop");
      event.getLine().close();
    }
  }
  });

  clip.start();

  }


  public static void main(String[] args) {
    c cc=new c();
  }

}