if (button.getText().equals("Reset")) {
    for (int i = 0; i < walls.size(); i++) {
        walls.remove(((int)i));
    }
    repaint();
}