class ButtonListener implements ActionListener {
    @Override 
    public void actionPerformed(ActionEvent e) {
        // DON'T DO THIS!
        if (e.getSource() == someButton) doThis();
        if (e.getSource() == someOtherButton) doThad();
    }
}