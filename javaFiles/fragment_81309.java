JPanel panel = new JPanel(new GridBagLayout());
gbc = new GridBagConstraints();
// Just to give a space between the components
gbc.insets = new Insets(5, 5, 5, 5);

for (int i = 0; i < ELEMENTS; i++) {
    Image image = ImageIO.read(file[i]);
    Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(imageScaled);
    foodImage[i] = new JLabel(imageIcon);
    foodLabel[i] = new JLabel("Label");
    qtyField[i] = new JTextField(3);
}

gbc.gridx = 0;
for (int i = 0; i < ELEMENTS; i++) {
    if (i % 3 == 0) {
        gbc.gridy += 2;
        gbc.gridx = 0;
    }

    // Add the image
    panel.add(foodImage[i], gbc);
    // Below the image
    gbc.gridy++;
    // Add the label
    panel.add(foodLabel[i], gbc);
    // Go back up
    gbc.gridy--;
    // Next column
    gbc.gridx++;
    // Add the textfield
    panel.add(qtyField[i], gbc);
    // Next column
    gbc.gridx++;
    tabbedPane.addTab(text, panel);
}