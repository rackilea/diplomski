public static void main(String[] args) {
        new JFXPanel();
        final JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JTextField tf = new JTextField("Hello World");
        frame.getContentPane().add(tf,
                BorderLayout.CENTER);
        tf.getInputMap((JComponent.WHEN_FOCUSED)).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), "Ctrl+S");
        tf.getActionMap().put("Ctrl+S", new SaveAction());
        frame.setJMenuBar(new DummyMenuBar());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
        static class SaveAction extends AbstractAction {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if((e.getSource() instanceof JTextField)){
            System.out.println(".handle() in Action");
            }
        }
    }