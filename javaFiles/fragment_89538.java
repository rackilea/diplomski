public SimpleTableDemo() {
    super(new GridLayout(1, 0));

    ...
    // pass the reference of this object
    createAndShowGUI(this);
}

private static void createAndShowGUI(SimpleTableDemo newContentPane ) {
    ...

    //remove this line
    //SimpleTableDemo newContentPane = new SimpleTableDemo();
    ...
}