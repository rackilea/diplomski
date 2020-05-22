public static void main(final String args[]) {
    JFrame frame = new JFrame("JToolBar Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JToolBar toolbar = new JToolBar();

    toolbar.add(new JButton("button"));
    toolbar.add(new JButton("button 2"));

    Container contentPane = frame.getContentPane();
    //contentPane.add(toolbar, BorderLayout.NORTH);
    contentPane.add(new JLabel("I want this to be under the toolbar"), BorderLayout.CENTER);

    JLayeredPane layeredPane = frame.getLayeredPane();
    layeredPane.setLayout(new BorderLayout());
    layeredPane.add(toolbar, BorderLayout.NORTH);

    // set the toolbar floating
    ((BasicToolBarUI) toolbar.getUI()).setFloatingLocation(10, 10);
    ((BasicToolBarUI) toolbar.getUI()).setFloating(true, null);

    // TODO - after application starts, manually dock the toolbar to any position (north/east...)

    frame.setSize(250, 100);
    frame.setVisible(true);
}