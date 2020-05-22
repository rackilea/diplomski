JFrame f = ...;
f.addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent we) {
      System.exit(0);
   }
});