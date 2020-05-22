button.addActionListener(new ActionListener() {
    /* called by the EDT when the button has been clicked */
    public void actionPerformed(ActionEvent e) {
        jtext.setText("HelloFromAWTThread");
    }
});