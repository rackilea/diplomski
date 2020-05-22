trayIcon.addMouseListener(new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
            if (e.isPopupTrigger()) {
                jpopup.setLocation(e.getX(), e.getY());
                jpopup.setInvoker(jpopup);
                jpopup.setVisible(true);
            }
        }
    });