dialog.addWindowListener(new WindowAdapter() {
        @Override
        public void windowOpened(WindowEvent e) {
            dialog.removeWindowListener(this);
            dialog.toFront();
        }
    });