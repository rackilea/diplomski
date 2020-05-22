JFrame frame = new JFrame("fade frame");
    frame.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            width = image.getWidth(frame);
            height = image.getHeight(frame);
        }
    });