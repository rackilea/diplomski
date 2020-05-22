private Image getCompatibleImage(BufferedImage img) throws IOException {
        GraphicsConfiguration c = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        if (c.getColorModel().equals(img.getColorModel()))
            return img;

        BufferedImage compatible = c.createCompatibleImage(img.getWidth(),
                img.getHeight());
        Graphics cg = compatible.getGraphics();
        cg.drawImage(img, 0, 0, null);
        cg.dispose();

        return compatible;
    }