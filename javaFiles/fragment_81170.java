public class MyFrame extends JFrame {
  private JLabel songName, songLength;

  public MyFrame() {
    super("SongApp");
    songLength = new JLabel("0:00");
    songName = new JLabel("No song selected yet");
    JButton loadFile = new JButton("Choose a new file ...");

    //other UI settings

    loadFile.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        createFileChooser(this);
      }
    });

    getContentPane().add(loadFile);
    getContentPane().add(songLength);
    getContentPane().add(songName);
  }

  public void changeWindowInformation(String filename, int time) {
    this.songName.setText(filename);
    this.songLength.setText(yourFormattedTime); 
  }
}