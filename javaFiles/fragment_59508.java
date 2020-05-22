int xx = label.getBounds().getX();
int yy = label.getBounds().getY();
int ww = label.getBounds().getWidth();
int hh = label.getBounds().getHeight();

//to the right 10 units
xx+=10;
label.setBounds( xx, yy, ww, hh );