public void setup() {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(0, 0);
    frame.setTitle("Circles");
    JPanel p = new MouseHandler();
    frame.add(p);
    frame.addMouseListener(p);
    frame.addMouseMotionListener(p);
    frame.setVisible(true);
}