public class ShootingGallery extends JApplet implements MouseMotionListener {

// VARIABLES
int mouseXPos;
int mouseYPos;
Image myImage;

@Override
public void init() {
    setSize(800, 600);// SET UP CURSOR IMAGE
    myImage = getImage(getDocumentBase(), "spongebob.gif");
    addMouseMotionListener(this);// ADD ACTION LISTENERS
    this.add(new PaintContainer());

}
@Override
public void mouseDragged(MouseEvent arg0) {
}

@Override
public void mouseMoved(MouseEvent e) {
    moveMouse(e);
    repaint();
}

public void moveMouse(MouseEvent e) {
    mouseXPos = e.getX() - (myImage.getWidth(null) / 2);
    mouseYPos = e.getY() - (myImage.getHeight(null) / 2);
}

public class PaintContainer extends JPanel {

     protected void paintComponent(Graphics g) {
         g.drawImage(myImage, mouseXPos, mouseYPos, this);
     }
}
}