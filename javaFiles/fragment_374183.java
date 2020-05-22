if (Character.isLetterOrDigit(e.getKeyChar())) {
    filterField.setText(null);
    filterField.requestFocusInWindow();
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            filterField.dispatchEvent(e);
        }
    });
}