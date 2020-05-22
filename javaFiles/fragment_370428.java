private void setupGUI() {
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weighty = 1;
    this.add(getPanel(1, 4), gbc);
    this.add(getPanel(2, 2), gbc);
}