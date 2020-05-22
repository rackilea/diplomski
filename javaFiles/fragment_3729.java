public static void addComponentsToPane(Container pane) {

    textArea = new JLabel(" ");
    pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
    pane.add(new MyMath().textField);  //MyMath instance 1
    pane.add(new MyMath().button);  //MyMath instance 2
    pane.add(new MyMath().comment);  //MyMath instance 3
    pane.add(textArea);
}