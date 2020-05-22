private static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice().getDefaultConfiguration();
    }    

BufferedImage tmpImage = getGraphicsConfiguration().create(newWidth, newHeight, Transparency.TRANSLUCENT);
          Graphics2D g2d = (Graphics2D)tmpImage.getGraphics();
          g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
          g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g2d.drawImage(image, 0, 0, newWidth, newHeight, null);