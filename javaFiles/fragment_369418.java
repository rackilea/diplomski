private static void addPhotoComponent(File file) {
    Image image = null;
    try {
        image = ImageIO.read(file);
    } catch (IOException e2) {
        System.out.println("ERROR: Couldn't get image.");
    }

    img = new PhotoComponent(image, contentArea);
    img.revalidate();

    img.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                // your code here
                System.out.println("You flipped the photo!!!");
                flipImage();
                img.repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            img.setOval(e.getX(), e.getY());
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            img.removeOval();
        }
    });

    img.addMouseMotionListener(new MouseAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            int[] toUpdate = img.setOval(e.getX(), e.getY());
            oldX = toUpdate[0];
            oldY = toUpdate[1];
        }
    });

    if (img != null) {
        contentArea.add(img);
    }
}