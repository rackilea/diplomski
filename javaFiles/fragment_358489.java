JPanel panel = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            BufferedImage image = null; // get your buffered image.
            Graphics2D graphics2d = (Graphics2D) g;
            graphics2d.drawImage(image, 0, 0, null);
            super.paintComponents(g);
        }
    };