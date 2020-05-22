private static void createAndShowGui() {
  JFrame frame = new JFrame("My JFrame");
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  // add your components to your JFrame here

  frame.pack();
  frame.setLocationByPlatform(true);
  frame.setVisible(true);
}

// the main method which Java uses as the starting point for your program
public static void main(String[] args) {

  // let's call our Swing GUI in a thread-safe manner
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        createAndShowGui();
     }
  });
}