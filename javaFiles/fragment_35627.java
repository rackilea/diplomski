public ListenerDemo() {

    addMouseMotionListener(new MouseMotionListener() {
        // NOT IMPLEMENTED:
        public void mouseDragged(MouseEvent e) {}

        // IMPLEMENTED:
        public void mouseMoved(MouseEvent e) {
            labelX.setText("X : "+e.getX());
            labelY.setText("Y : "+e.getY());
        }
    });

    // remaining code
}