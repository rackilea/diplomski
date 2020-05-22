protected void addTo(JPanel parent, JLabel label, JSlider slider, JTextField field, int gridY) {

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = gridY;
    parent.add(label, gbc);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx++;
    gbc.weightx = 1;
    parent.add(slider, gbc);

    gbc.gridx++;
    gbc.weightx = 0;
    parent.add(field, gbc);

}