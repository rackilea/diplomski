KeyAdapter btnSaveEnabler = new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            try {
                btnSave.setEnabled(!(Integer.parseInt(textQuantity.getText()) < 1));
            } catch (NumberFormatException nfe) {
                btnSave.setEnabled(false);
            }
    }
};