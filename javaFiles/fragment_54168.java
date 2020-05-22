public class ClosableWindow extends JFrame {
  public void setUp() {
    JPanel mainPanel = createMainPanel();

    int mask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    KeyStroke closeKey = KeyStroke.getKeyStroke(KeyEvent.VK_W, mask);

    mainPanel.getInputMap().put(closeKey, "closeWindow");        

    mainPanel.getActionMap().put("closeWindow", 
        new AbstractAction("Close Window") {
          @Override public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
          }
        });

    getContentPane().add(mainPanel);      
  }
}