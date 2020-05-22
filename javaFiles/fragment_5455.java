static {
  Webcam.setDriver(new V4l4jDriver()); // this is important
}

public static void main(String[] args) {
  JFrame frame = new JFrame("V4L4J Webcam Capture Driver Demo");
  frame.add(new WebcamPanel(Webcam.getDefault()));
  frame.pack();
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}