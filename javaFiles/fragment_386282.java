addWindowStateListener(new WindowStateListener() {

        @Override
        public void windowStateChanged(WindowEvent e) {
                firePropertyChange(EXTENDED_STATE_KEY, e.getOldState(), e.getNewState());
        }
    });