EventQueue.invokeLater(new Runnable(){
  public void run(){
    JLabel label = new JLabel();

    label.setHorizontalAlignment(SwingConstants.CENTER);

    try{
      // URL imageURL = new URL("http://static.ak.fbcdn.net/rsrc.php/v2/yb/r/GsNJNwuI-UM.gif");
      URL imageURL = new URL("http://i34.photobucket.com/albums/d129/nirendaran/Speed/verify_anim.gif");

      label.setIcon(new ImageIcon(imageURL));
    }
    catch (MalformedURLException ex){
      ex.printStackTrace();
    }

    JFrame frame = new JFrame();
    frame.add(label, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setMinimumSize(new Dimension(160, 120));
    frame.setVisible(true);
  }
});