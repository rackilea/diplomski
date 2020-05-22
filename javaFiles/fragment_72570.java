JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

//or if you are using awt

 Frame frame = new Frame();
 frame.addWindowListener(new WindowAdapter() {
     // handle the window closing event here
  });