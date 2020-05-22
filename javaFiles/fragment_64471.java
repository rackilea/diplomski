private JTextArea txt2 = new JTextArea() {
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
};