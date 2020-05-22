public static void frameTest() throws InterruptedException {
  final JFrame jf = new JFrame("Hello World");
  jf.setBounds(100, 100, 400, 400);
  jf.setVisible(true);
  Thread.sleep(8000);
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        jf.dispose();
     }
  });
}