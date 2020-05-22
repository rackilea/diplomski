public void actionPerformed(ActionEvent e) {

    x += delta;
    if (x > 500) {
        delta *= -1;
        x = 500;
    } else if (x < 100) {
        delta *= -1;
        x = 100;
    }

    repaint();
}