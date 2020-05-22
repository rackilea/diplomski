ImageIcon icon = createImageIcon("map.jpg", "My ImageIcon");

if (icon != null) {
    JLabel picture = new JLabel("HERE IS ICON", icon, JLabel.CENTER);
    picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
    picture.setHorizontalAlignment(JLabel.CENTER);

    scrollPane.setViewportView(picture);
}