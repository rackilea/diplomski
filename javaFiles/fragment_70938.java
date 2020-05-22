public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    for (int j=0;j<30;j++) {
        double sc = Math.random() * 30 + 10;
        AffineTransform tx = new AffineTransform();
        tx.scale(sc, sc);
        tx.translate(Math.random() * 50, Math.random() * 50);
        g2.setTransform(tx);
        g2.setStroke(new BasicStroke(0.01f ));
        g2.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255),(int) (Math.random()*255)));
        double x1,y1;
        double x0 = 0;
        int nPoints = 1500;
        double y0 = Math.E-2;

        for(int i=0;i<nPoints;i++) {
            double t= 12*i*Math.PI/nPoints;
            x1=(Math.sin(t)*(Math.pow(Math.E,Math.cos(t))-2*Math.cos(4*t)-Math.pow(Math.sin(t/12),5)));
            y1 = (Math.cos(t)*(Math.pow(Math.E,Math.cos(t))-2*Math.cos(4*t)-Math.pow(Math.sin(t/12),5)));
            g2.draw(new Line2D.Double(x0,y0,x1,y1));
            x0=x1;
            y0=y1;
        }
    }
}