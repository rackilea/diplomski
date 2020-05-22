// With explicit casting
public void paint (Graphics g) {    
        Rectangle r = new Rectangle(xPos, yPos, width, height);
        g.fillRect(
           (int)r.getX(),
           (int)r.getY(),
           (int)r.getWidth(),
           (int)r.getHeight()
        );  
    }