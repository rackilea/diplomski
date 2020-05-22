public void setupPanel() {
    final JTextArea textArea = new JTextArea();
    textArea.setText("Write your response here");
    textArea.addAncestorListener(new AncestorListener() {
        public void ancestorRemoved(AncestorEvent event) { }
        public void ancestorMoved(AncestorEvent event) { }
        public void ancestorAdded(AncestorEvent event) {
            if (event.getSource() == textArea) {
                textArea.selectAll();
                textArea.requestFocusInWindow();
            }
        }
    });
    add(textArea);
}