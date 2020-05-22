jFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowDeactivated(WindowEvent e) {
            if(e.getOppositeWindow() instanceof JDialog) {
                JDialog dialog = (JDialog) e.getOppositeWindow();
                if(dialog.isModal()) {
                    // do stuff
                }
            }
        }
    });