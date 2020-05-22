private void updateView() {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            synchronized (viewSynchronizationObject) {
                if (view == null) {
                    return;
                }
                MessagesPanelControl mpc = view.get();
                if (mpc != null) {
                    mpc.updateView();
                } 
            }
        }


 },false);
}