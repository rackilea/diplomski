private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("DynamicTreeDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    BadTree newContentPane = new BadTree();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
}