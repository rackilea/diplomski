GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
Rectangle bounds = gd.getDefaultConfiguration().getBounds();
Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());

Rectangle safeBounds = new Rectangle(bounds);
safeBounds.x += insets.left;
safeBounds.y += insets.top;
safeBounds.width -= (insets.left + insets.right);
safeBounds.height -= (insets.top + insets.bottom);

System.out.println("Bounds = " + bounds);
System.out.println("SafeBounds = " + safeBounds);

Area area = new Area(bounds);
area.subtract(new Area(safeBounds));
System.out.println("Area = " + area.getBounds());