fileItem1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser(null);
        if (chooser.showOpenDialog() != JFileChooser.CANCEL_OPTION) {
            // ...
        }
    }
});