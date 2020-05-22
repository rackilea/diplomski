public void endGame() {
    myIcon = new ImageIcon("portal-cake.jpg");
    JLabel label = new JLabel(myIcon);
    this.setLayout(new GridLayout());
    this.add(label);
    this.validate();
}