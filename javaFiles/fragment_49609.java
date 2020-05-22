private void buildPanel() {
    this.panel = new JPanel(new GridLayout(0, 3));
    this.messageLabel = new JLabel("Input: ");
    this.kilotextfield = new JTextField();
    this.calcbutton = new JButton("Calculate");

    this.panel.add(this.messageLabel);
    this.panel.add(this.kilotextfield);
    this.panel.add(this.calcButton);
}