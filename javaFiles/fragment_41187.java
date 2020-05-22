BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            BufferedImage imageRGB = new BufferedImage(
                bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.OPAQUE);
            Graphics2D graphics = imageRGB.createGraphics();
            graphics.drawImage(bufferedImage, 0, 0, null);
            ImageIO.write(imageRGB, "jpg", file);