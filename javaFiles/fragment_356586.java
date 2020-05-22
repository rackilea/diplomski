diag_ap.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            MyJFrame.this.setEnabled(true); // replace MyJFrame with name of your JFrame
        }
    });