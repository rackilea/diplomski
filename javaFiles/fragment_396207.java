if (SwingUtilities.isEventDispatchThread()) {
    // code
} else {
    SwingUtilities.invokeLater(new Runnable () {
        public void run () {
            // code
        }
    });
}