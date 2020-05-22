public ListenerTest() {
    // Create components...

    panelA.getActionMap().put("saveAction", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("F2");
        }
    });

    //panelA.getInputMap().put(KeyStroke.getKeyStroke("F2"), "saveAction");
    panelA.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
              .put(KeyStroke.getKeyStroke("F2"), "saveAction");

    //this.addKeyListener(new KeyAdapter() {
    //mainPanel.addKeyListener(new KeyAdapter() {
    panelA.addKeyListener(new KeyAdapter() {
    //buttonA.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent arg0) {
            System.out.println("Panel A: " + arg0.getKeyChar());
        }
    });

    // Rest of the code...
}