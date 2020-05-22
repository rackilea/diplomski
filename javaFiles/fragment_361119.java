JButton actionButton;
JPanel buttonMoverPanel = new JPanel();

public ButtonMover() {
  buttonMoverPanel.setLayout(new GridBagLayout());
  this.add(buttonMoverPanel);
  this.setSize(500, 500);
  this.setResizable(true);
  this.setVisible(true);

  JButton actionButton = new JButton("Testing Button"); // ****** here