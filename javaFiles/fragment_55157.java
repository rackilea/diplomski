<myJFrame>.addWindowFocusListener(new WindowFocusListener() {

        @Override @SuppressWarnings("unused")
        public void windowLostFocus(WindowEvent e) {
            ToolTipManager.sharedInstance().setEnabled(false);
        }


        @Override @SuppressWarnings("unused")
        public void windowGainedFocus(WindowEvent e) {
            ToolTipManager.sharedInstance().setEnabled(true);
        }
    });