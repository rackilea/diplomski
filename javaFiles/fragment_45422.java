new Timer(750, new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    contentPane.setBackground((Color.getHSBColor((c/360), 1, 1));
    contentPane.repaint();
    c= (c >= 360) ? 1 : c + 5;
  }
}).start();