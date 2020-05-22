private int x;

protected void paintComponent(Graphics g) {
    //draw the images at location x
}

// elsewhere, initialize a javax.swing.Timer to increment x every 15 ms
new Timer(15, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        x += 5;
        repaint();
    }
}.start();