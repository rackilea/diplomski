Graphics g = null;  // *******  this is null!!!!
Graphics2D g2 = (Graphics2D) g;  // ***** it's *STILL* null!!
//Graphics2D g2 = new Graphics();
Font font = new Font("SansSerif", Font.BOLD, 28);
Ellipse2D E1 = new Ellipse2D.Double(x, y-110, w, h);
g2.setColor(Color.red);   // ***** it's *STILL* null!!
g2.draw(E1);   // ***** it's *STILL* null!!
g2.fill(E1); // **** etc...