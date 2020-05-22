btnEdit.addActionListener(new ActionListener() {
    private boolean wasClicked = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (wasClicked) {
            // Do nothing if clicked already
            return;
        } else {
            // The button was clicked for the first time
            wasClicked = true;
        }

        for (int i = 0; i < table.getRowCount(); i++) {
            // Your stuff
            ...
        }
    }
});