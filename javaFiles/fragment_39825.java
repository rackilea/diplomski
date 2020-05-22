BufferedImage temp = new BufferedImage(source.getWidth(), source.getHeight(), 
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = temp.createGraphics();
    g2.setColor(Color.green);
    g2.fillRect(0, 0, source.getWidth(), source.getHeight());
    g2.drawImage(0, 0, source, null);
    g2.dispose();