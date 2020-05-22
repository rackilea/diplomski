public class MyFirstGui {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {

        MousePanel panel = new MousePanel();
        panel.setBounds(0,0,500,430);
        MyGui myGUI = new MyGui(panel);
        myGUI.createGUI();
        myGUI.getContentPane().add(panel);
        myGUI.setVisible(true);
      }
    });
  }
}