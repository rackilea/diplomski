BufferedImage masked = new BufferedImage(city.getWidth(), city.getHeight(), BufferedImage.TYPE_INT_ARGB);
g2d = masked.createGraphics();
g2d.setColor(Color.RED);
g2d.fillRect(0, 0, masked.getWidth(), masked.getHeight());
g2d.drawImage(city, 0, 0, null);
g2d.setComposite(AlphaComposite.DstAtop);
g2d.drawImage(mask, 0, 0, null);
g2d.dispose();