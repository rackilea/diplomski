...
ExitListener listener = new ExitListener();
button.addActionListener(listener)
...
private class ExitListener implements ActionListener {
    @Override
    public void actionPerformed (ActionEvent e) {
        System.exit(0);
    }
}