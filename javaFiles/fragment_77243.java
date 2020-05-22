public void paint(Graphics g) 
{

        controls();
        Dimension currentSize  = getSize();
        if ( ! currentSize.equals(size) ) {
          size = currentSize;
          buf = createImage(size.width,size.height); 
          g2d = buf.getGraphics();
        }
        //g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(0,0,size.width,size.height);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Welcome 2 Java!!", (int) 50, 60 );
        //g2d.drawString("Welcome to Java!!", (int) p1.x, 60 );


        g.drawImage(buf, 0, 0, this);

}