public void itemStateChanged(ItemEvent e) {

    if (blue.getState()) {
        f.setBackground(Color.BLUE);
    } else if (red.getState()) {
        f.setBackground(Color.RED);
    } else if (yellow.getState()) {
        f.setBackground(Color.YELLOE);
    } else if (pink.getState()) {
        f.setBackground(Color.PINK);
    } else if (gray.getState()) {
        f.setBackground(Color.GRAY);
    }
}