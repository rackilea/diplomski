Graphics2D g2d = (Graphics2D)g;    
Font font = new Font("Arial", Font.PLAIN, 12);

g2d.setFont(font);
g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
g2d.drawString("Hello World", 25, 100);