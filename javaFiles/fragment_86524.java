label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            System.out.println("CLICKED: " + "(" + e.getX() + "," + e.getY() + ")");
            image.setRGB(e.getX(), e.getY(), Color.RED.getRGB());
            frame.repaint();
        }
    });