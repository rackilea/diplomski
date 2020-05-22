@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (image != null) {
        g2D = (Graphics2D) image.getGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(image, 0, 0, AREA_WIDTH, AREA_HEIGHT, null);
    }

    //SETTING STROKE FOR SHAPES
    BasicStroke basicStroke = new BasicStroke(thickness);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(basicStroke);
    g2d.setPaint(currentColor);

    if(g2d != null) {
// ENUMROPE = IS ENUM CLASS USED LIKE BRIDGE BETWEEN MAIN CLASS AND DRAWING AREA
        if (figures == EnumRope.RECT && rectangle != null) {

                g2d.draw(rectangle);

        }else if(figures == EnumRope.FILLEDRECT && rectangle != null){

                g2d.fill(rectangle);

        }else if (figures == EnumRope.OVAL && ellipse2d != null) {

                g2d.draw(ellipse2d);

        }else if (figures == EnumRope.FILLEDOVAL && ellipse2d != null){

                g2d.fill(ellipse2d);

        }else if (figures == EnumRope.LINE && line2d != null) {

                g2d.draw(line2d);

        }else if(figures == EnumRope.PENCIL && ErasRect != null){

                g2d.fill(ErasRect);

        }else if(figures == EnumRope.ERASER && ErasRect != null){

                g2d.fill(ErasRect);

        }

    }

}


public void clear()
{   //INVOKING CLEARAREA METHOD
    clearArea();
    repaint();
}

public void clearArea() {
   //THERE CREATED NEW IMAGE TO CLEAN DRAW AREA & ERASE ALL DRAWN SHAPES
    image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_ARGB);
}
public void addRectangle(Rectangle rectangle, Color color, int tickness)
{
    //  DRAW THE RECTANGLE ONTO THE BUFFEREDIMAGE
    BasicStroke basicStroke = new BasicStroke(tickness);
    Graphics2D g2d = (Graphics2D)image.getGraphics();
    g2d.setStroke(basicStroke);
    g2d.setColor( currentColor );
    if(figures==EnumRope.FILLEDRECT){
        g2d.fill( rectangle );
    }else {
        g2d.draw( rectangle );
    }
        repaint();
}
public void addEllipse(Ellipse2D.Float ellipse2D, Color color, int tickness)
{
    //  DRAW THE OVAL(circle) ONTO THE BUFFEREDIMAGE
    BasicStroke basicStroke = new BasicStroke(tickness);
    Graphics2D g2d = (Graphics2D)image.getGraphics();
    g2d.setStroke(basicStroke);
    g2d.setColor( currentColor );
    if(figures == EnumRope.FILLEDOVAL) {
        g2d.fill( ellipse2D );
    }else {
        g2d.draw( ellipse2D );
    }
        repaint();
}
public void addLine(Line2D.Float line2D, Color color, int tickness)
{
    //  DRAW THE LINE ONTO THE BUFFEREDIMAGE
    BasicStroke basicStroke = new BasicStroke(tickness);
    Graphics2D g2d = (Graphics2D)image.getGraphics();
    g2d.setStroke(basicStroke);
    g2d.setColor( currentColor );
    g2d.draw( line2D );
    repaint();
}
public void addEraser(Rectangle2D.Float erasRect, Color color, int tickness)
{
   //  DRAW THE ERASER(WHITE,CONSTANT RECTANGLE) ONTO THE BUFFEREDIMAGE
    BasicStroke basicStroke = new BasicStroke(tickness);
    Graphics2D g2d = (Graphics2D)image.getGraphics();
    g2d.setStroke(basicStroke);
    g2d.setColor(Color.WHITE);
    g2d.fill(erasRect);
    repaint();
}
public void addPencil(Rectangle2D.Float erasRect, Color color, int tickness)
{
    // DRAW THE PENCIL(COLORED,CONSTANT RECTANGLE) ONTO THE BUFFEREDIMAGE
    BasicStroke basicStroke = new BasicStroke(tickness);
    Graphics2D g2d = (Graphics2D)image.getGraphics();
    g2d.setStroke(basicStroke);
    g2d.setColor(currentColor);
    g2d.fill(erasRect);
    repaint();
}
//NEW INNER CLASS FOR MOUSEADAPTER
class MyMouseListener extends MouseInputAdapter{

private Point startpoint;

@Override
public void mousePressed(MouseEvent e) 
{
    startpoint = e.getPoint();
    rectangle = new Rectangle();
    oldX = e.getX();
    oldY = e.getY();
    repaint();

if(figures == EnumRope.TEXT){

        text = JOptionPane.showInputDialog("Write Your Text Here : ");
        g2D.setFont(myFont);
        g2D.setColor(currentColor);
        g2D.drawString(text, oldX, oldY);
        repaint();

    }
}

@Override
public void mouseDragged(MouseEvent e) {
    currentX = e.getX();
    currentY = e.getY();
    int x = Math.min(startpoint.x, e.getX());
    int y = Math.min(startpoint.y, e.getY());
    int width = Math.abs(startpoint.x - e.getX());
    int height = Math.abs(startpoint.y - e.getY());

    rectangle.setBounds(x, y, width, height);
    repaint();
    ellipse2d = new Ellipse2D.Float(x, y, width, height);
    repaint();
    line2d = new Line2D.Float(oldX, oldY, currentX, currentY);
    repaint();
    ErasRect = new Rectangle2D.Float(currentX, currentY, thickness, thickness);
    repaint();

  // WE NEED ADD THIS TWO SHAPE HERE BECAUSE SHAPE DARWING WITH MOUSEDRAG !
        if (figures == EnumRope.ERASER) {
            addEraser(ErasRect, Color.WHITE, thickness);
            ErasRect = null;
        }else if (figures == EnumRope.PENCIL) {
            addPencil(ErasRect, currentColor, thickness);
            ErasRect = null;
        }
}

// GETTING RELEASED COORDINATE TO DRAW SHAPES BECAUSE SOME SHAPES GETTED 
//COORDINATES FROM MOUSEDRAGGED, IF YOU ADD THE SHAPE TO IMAGE IN MOUSEDRAGGED 
//SHAPE WILL BE NESTED( more nested shapes from small to big). SO ADD ALL 
//COORDINATES WHEN MOUSE RELEASED.

@Override 
public void mouseReleased(MouseEvent e) {

 if (figures == EnumRope.OVAL) {
        addEllipse(ellipse2d, currentColor, thickness);
        ellipse2d = null;
    } else if (figures == EnumRope.FILLEDOVAL) {
        addEllipse(ellipse2d, currentColor, thickness);
        ellipse2d = null;
    } else if (figures == EnumRope.RECT) {
        addRectangle(rectangle, currentColor, thickness);
        rectangle = null;
    } else if (figures == EnumRope.FILLEDRECT) {
        addRectangle(rectangle, currentColor, thickness);
        rectangle = null;
    } else if (figures == EnumRope.LINE) {
        addLine(line2d, currentColor, thickness);
        line2d = null;
    }

    }
}