private static class HelloActionListener implements ActionListener {

    private JTextArea textArea;
    public HelloActionListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setText("Hello");
    }
}