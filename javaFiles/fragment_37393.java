Font font = new Font("Arial", Font.BOLD, 48);
for (Component comp : getComponents()) {
    if (comp instanceof JButton) {
        ((JButton)comp).setFont(font);
    }
}