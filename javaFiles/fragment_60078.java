Action fieldAction = new AbstractAction("fieldAction") {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello " + ((JTextComponent) e.getSource()).getText());
        }
    };
    JTextField field = new JTextField("this is a normal field");
    MultiplexingTextField multiplexing = new MultiplexingTextField(20);
    multiplexing.addKeyStrokes(KeyStroke.getKeyStroke("ENTER"));
    field.setAction(fieldAction);
    multiplexing.setAction(fieldAction);
    Action action = new AbstractAction("default button action") {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello - got default button");
        }
    };
    JButton button = new JButton(action);
    JPanel panel = new JPanel();
    panel.add(field);
    panel.add(multiplexing);
    panel.add(button);
    // this is swingx testing support, simply replace with normal frame creation
    JXFrame frame = wrapInFrame(panel, "multiplex");
    frame.getRootPane().setDefaultButton(button);