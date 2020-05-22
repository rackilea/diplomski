for (int i = 0; i < 5; i++) {
    final JTextPane b = new JTextPane();
    b.setBorder(new JTextArea().getBorder());
    b.addFocusListener(new FocusListener() {

        @Override
        public void focusGained(FocusEvent arg0) {
            b.repaint();
        }

        @Override
        public void focusLost(FocusEvent arg0) {
            b.repaint();
        }

    });
    b.setText(Integer.toString(i));
    a.getContentPane().add(b);
}