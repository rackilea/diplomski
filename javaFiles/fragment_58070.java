private static Controller instance;

...

private static void createAndShowGUI() {
    JFrame frame = new JFrame("MainPanel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    instance = new Controller();
    frame.getContentPane().add(instance);
    frame.setSize(800, 600);
    frame.setVisible(true);
}