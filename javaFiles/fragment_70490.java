Area outter = new Area(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
        int x = (img.getWidth() / 4) ;
        int y = (img.getHeight() / 4);
        Ellipse2D.Double inner = new Ellipse2D.Double(x,y, img.getWidth()/2, img.getHeight()/2);
        outter.subtract(new Area(inner));// remove the ellipse from the original area

        g2d.setColor(Color.BLACK);
        g2d.fill(outter);