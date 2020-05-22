@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    if(zoomer==true){    
        at = new AffineTransform();
        at.scale(zoomFactor,zoomFactor);
        zoomer=false;
        g2.transform(at);
    }
 }