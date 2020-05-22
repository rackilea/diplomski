private static void CreateAndShowGUI() {
    frame = new JFrame("Writing Surface v0.1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.LIGHT_GRAY);
    frame.getContentPane().add(new MyPanel(), BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
}