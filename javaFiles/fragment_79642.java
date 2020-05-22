c.addMouseListener(new MouseAdapter() {
public void mouseEntered(MouseEvent e) {
    System.out.println("Mouse entry event: " + e
                       + " on button: " + buttonLabel);
  }
});