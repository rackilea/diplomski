public void run() {
    // Start here
    SwingUtilities.invokeLater(new Runnable()
    {
        @Override
        public void run() {
            long time = getElapsedTime();
            sidePanel.this.clock.setText(String.valueOf(time));
        }
    });
    // End here...
}