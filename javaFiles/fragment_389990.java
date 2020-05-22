myscrollbar.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            if(overScrollOffTimer != null) {
                overScrollOffTimer.stop();
                overScrollOffTimer = null;
            }
            mymodel.setOverScrollbar(true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(overScrollOffTimer == null) {
                overScrollOffTimer = new Timer(250,
                        overScrollOffListener);
                overScrollOffTimer.start();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(activeScrollOffTimer != null) {
                activeScrollOffTimer.stop();
                activeScrollOffTimer = null;
            }
            mymodel.setBeingScrolled(true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(activeScrollOffTimer == null) {
                activeScrollOffTimer =
                    new Timer(250,
                              activeScrollOffListener);
                activeScrollOffTimer.start();
            }
        }
    });