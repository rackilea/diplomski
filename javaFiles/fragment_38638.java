chartPanel.addMouseWheelListener(new MouseWheelListener() {
        public void mouseWheelMoved(MouseWheelEvent arg0) {
            if (arg0.getWheelRotation() > 0) {
                chartPanel.zoomOutDomain(0.5, 0.5);
            } else if (arg0.getWheelRotation() < 0) {
                chartPanel.zoomInDomain(1.5, 1.5);
            }
        }
    });