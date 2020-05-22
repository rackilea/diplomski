ByteArrayOutputStream baos=new ByteArrayOutputStream();
    BufferedImage img=ImageIO.read(new File(ImageName));
    ImageIO.write(img, "jpg", baos);
    baos.flush();

    return baos.toByteArray();