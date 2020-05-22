BufferedImage texture = new BufferedImage(1, 30, BufferedImage.TYPE_INT_RGB);
Graphics2D g = texture.createGraphics();
g.setColor(Color.white);
g.fillRect(0, 0, 1, 30);
g.setColor(new Color(0x26A2D6));
g.fillRect(0, 0, 1, 20);
g.dispose();

TexturePaint texturePaint = new TexturePaint(texture,
    texture.getRaster().getBounds());