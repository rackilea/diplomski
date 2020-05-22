public void setup() {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(0, 0);
    frame.setTitle("Circles");
    frame.add(new MouseHandler());// your panel
    frame.addMouseListener(new MouseHandler()); // your listener, also a panel, but not the one you added to your frame
    frame.addMouseMotionListener(new MouseHandler()); // yet another listener, also not the panel you added to your frame
    frame.setVisible(true);
}