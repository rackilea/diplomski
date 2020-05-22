public static void addComponentsToPane(Container pane) {

        MyMath myMath = new MyMath();

        textArea = new JLabel(" ");
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        pane.add(myMath.textField);
        pane.add(myMath.button);
        pane.add(myMath.comment);
        pane.add(textArea);
    }