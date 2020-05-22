BufferedImage city = ImageIO.read(new File("/Users/swhitehead/Downloads/City.jpg"));

BufferedImage mask = new BufferedImage(city.getWidth(), city.getHeight(), BufferedImage.TYPE_INT_ARGB);

Graphics2D g2d = mask.createGraphics();
Color transparent = new Color(255, 0, 0, 0);
Color fill = Color.RED;
RadialGradientPaint rgp = new RadialGradientPaint(
                new Point2D.Double(955, 185),
                185,
                new float[]{0f, 0.75f, 1f},
                new Color[]{transparent, transparent, fill});
g2d.setPaint(rgp);
g2d.fill(new Rectangle(0, 0, mask.getWidth(), mask.getHeight()));
g2d.dispose();