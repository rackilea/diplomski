void addKeyBinding(JComponent jc) {
        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "A pressed");
        jc.getActionMap().put("esc pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("A pressed");
            }
        });

        jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "A released");
        jc.getActionMap().put("A released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("A released");
            }
        });
}