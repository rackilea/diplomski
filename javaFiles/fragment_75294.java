void setup() {

  ((JFrame)frame).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

  frame.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent we) {
      if (reallyExit) {
        frame.dispose();
      }
    }
  }
  );
}