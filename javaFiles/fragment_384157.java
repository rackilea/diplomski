private javax.swing.Timer paintTimer;

public void start() {
    // Your normal setup...

    paintTimer = new javax.swing.Timer(250, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Graphics gr = getGraphics();      
            paint(gr);
        }
    });
    paintTimer.setRepeats(true);
    paintTimer.setCoalesce(true);
    paintTimer.start();
}

public void mouseMoved( MouseEvent e ) {
    x = e.getX();
    y = e.getY();

    // You could wait for the timer to trigger the repaint for you...
    repaintTimer.restart();

    Graphics gr = getGraphics();      
    paint(gr);
}