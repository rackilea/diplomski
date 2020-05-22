public SimpleTableDemo() {
    super(new GridLayout(1, 0));

    ...
    createAndShowGUI();
}

private static void createAndShowGUI() {
    ...

    //Create and set up the content pane.
    SimpleTableDemo newContentPane = new SimpleTableDemo();
    ...
}