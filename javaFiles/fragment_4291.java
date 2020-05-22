private final Image                     image;                                  //

protected void paintForeground(Graphics2D gc, int wid, int hgt) {
    ...
    gc.drawImage(image,dx,dy,(dx+width),(dy+height),0,0,width,height,null);
    ...
    }