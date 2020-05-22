public Snake() {

    initlookandfeel();

    // I'm a new instance of a JFrame which has nothing to do with the
    // instance of Snake...
    jf = new JFrame();
    jf.setVisible(true);
    jf.setBounds(200, 200, 500, 500);
    jp = new JPanel();
    jp.setVisible(true);
    jf.setContentPane(jp);
    // Bad idea, JFrame uses a `BorderLayout` anyway, which will do the job you want
    jp.setLayout(null);
    // Bad idea
    // The frame contains a border, possibly a menu bar and other components.  The
    // visible size of the frame will actually be smaller then it's size...
    jp.setBounds(0, 0, jf.getWidth(), jf.getHeight());
    jf.setTitle("NIRAV KAMANI");
    jp.repaint();

}