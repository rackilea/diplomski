private static class RoundedBorder implements Border {

        private static BufferedImage img;

        static {
            try {
                img = ImageIO.read(RoundedBorder.class.getResource("resources/border.png"));
            } catch (Exception e) {
            }
        }
        private static final Insets SPACE_INSETS = new Insets(5, 5, 5, 5);
        private static final Insets INSETS = new Insets(SPACE_INSETS.top + 10, SPACE_INSETS.left + 10, SPACE_INSETS.bottom + 10, SPACE_INSETS.right + 10);

        @Override
        public Insets getBorderInsets(Component c) {
            return INSETS;
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Rectangle b = new Rectangle(x + SPACE_INSETS.left, y + SPACE_INSETS.top, width - (SPACE_INSETS.left + SPACE_INSETS.right + 1),
                    height - (SPACE_INSETS.top + SPACE_INSETS.bottom + 1));//top
            g.drawImage(img, b.x, b.y, b.x + 10, b.y + 10, 0, 0, 10, 10, null);
            g.drawImage(img, b.x + 10, b.y, b.x + b.width - 10, b.y + 10, 11, 0, 12, 10, null);
            g.drawImage(img, b.x + b.width - 10, b.y, b.x + b.width, b.y + 10, 22, 0, 32, 10, null);// bottom
            g.drawImage(img, b.x, b.y + b.height - 10, b.x + 10, b.y + b.height, 0, 22, 10, 32, null);
            g.drawImage(img, b.x + 10, b.y + b.height - 10, b.x + b.width - 10, b.y + b.height, 11, 22, 12, 32, null);
            g.drawImage(img, b.x + b.width - 10, b.y + b.height - 10, b.x + b.width, b.y + b.height, 22, 22, 32, 32, null);// left
            g.drawImage(img, b.x, b.y + 10, b.x + 10, b.y + b.height - 10, 0, 11, 10, 12, null);// right
            g.drawImage(img, b.x + b.width - 10, b.y + 10, b.x + b.width, b.y + b.height - 10, 22, 11, 32, 12, null);// fill
            g.drawImage(img, b.x + 10, b.y + 10, b.x + b.width - 10, b.y + b.height - 10, 15, 15, 16, 16, null);
        }
    }