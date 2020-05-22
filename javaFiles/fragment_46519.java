GradientPaint gp = new GradientPaint(0, 0, new Color(255, 0, 0, 50), 
                                   10, 10, new Color(128, 255, 0, 150));

ColorModel cm = ColorModel.getRGBdefault();
Rectangle r = new Rectangle(0, 0, 10, 10);
Raster raster = gp.createContext(cm, r, r, new AffineTransform(), null)
                  .getRaster(0, 0, 10, 10);

int[] rgba = raster.getPixel(5, 5, (int[])null);