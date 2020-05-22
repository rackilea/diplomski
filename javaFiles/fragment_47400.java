public void frame() {                                       //Frame setup
    frame = new JFrame("Pong");
    frame.setSize(width * scale, height * scale);
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);
    //frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c1 = frame.getContentPane();

    //...

    start();
    c1.add(main);
    graphic.requestFocus();
    frame.setVisible(true);
}