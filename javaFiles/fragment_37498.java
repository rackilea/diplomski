private static void debugMousePosition(JFrame frame) {
    final JFrame box = new JFrame("Mouse Position");
    box.setAlwaysOnTop(true);
    box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    box.setLocation(frame.getX() + 800,frame.getY());
    box.setSize(300, 100);
    box.setLayout(new GridLayout(1,2));
    box.setVisible(true);
    final JLabel X = new JLabel();
    final JLabel Y = new JLabel();
    frame.addMouseMotionListener(new MouseAdapter() {
        public void mouseMoved(MouseEvent me) {
            X.setText(String.valueOf("X Position: " + me.getX()));
            Y.setText(String.valueOf("Y Position: " + me.getY()));
            box.repaint();
        }
    });
    box.add(X);
    box.add(Y);

}