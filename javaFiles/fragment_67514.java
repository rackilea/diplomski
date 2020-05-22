BufferedImage oldImage = ImageIO.read(imageFile),
    newImage = new BufferedImage(dim, dim, oldImage.getType());
Graphics2D gfx = newImage.createGraphics();
gfx.drawImage(oldImage,
              -(oldImage.getWidth()-dim)/2, -(oldImage.getHeight()-dim)/2, null);
gfx.dispose();
ImageIO.write(newImage, "png", imageFile);