JDialog d = new JDialog(…);
Action submit = new AbstractAction("Submit") {

    @Override
    public void actionPerformed(ActionEvent e) {
        // handle submit
    }
};
private JButton b = new JButton(submit);
…
d.getRootPane().setDefaultButton(b);