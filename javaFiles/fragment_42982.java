if (...size changes) {
    SwingUtilities.invokeLater(new Runnable()) {
        @Overriden
        public void run() {
            ...setPreferredSize and revalidate
        }
    }
}