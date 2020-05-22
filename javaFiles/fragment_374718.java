public class ImageScreenShot extends JFrame implements MouseListener, MouseMotionListener {

int drag_status = 0, c1, c2, c3, c4;

public int getC1() {
    return c1;
}

public int getC2() {
    return c2;
}

public int getC3() {
    return c3;
}

public int getC4() {
    return c4;
}

public void cut() {
    GraphicalUserInterface.getFrame().addMouseMotionListener(this);
    GraphicalUserInterface.getFrame().addMouseListener(this);
}

public void draggedScreen() throws Exception {
    int w = c1 - c3;
    int h = c2 - c4;
    w = w * -1;
    h = h * -1;
    Robot robot = new Robot();
    BufferedImage img = robot.createScreenCapture(new Rectangle(c1, c2, w, h));
    File save_path = new File("screen1.jpg");
    ImageIO.write(img, "JPG", save_path);
    GraphicalUserInterface.getLabelIcon().setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH)));
    JOptionPane.showConfirmDialog(null, "Would you like to save your cropped Pic?");
    if (JOptionPane.YES_OPTION == 0) {
    /**Need to implement some code*/
    } else {
    /**Need to implement some code*/

    }
    System.out.println("Cropped image saved successfully.");
}

@Override
public void mouseClicked(MouseEvent arg0) {
}

@Override
public void mouseEntered(MouseEvent arg0) {
}

@Override
public void mouseExited(MouseEvent arg0) {
}

@Override
public void mousePressed(MouseEvent arg0) {
    c1 = arg0.getXOnScreen();
    c2 = arg0.getYOnScreen();
}

@Override
public void mouseReleased(MouseEvent arg0) {
    if (drag_status == 1) {
        c3 = arg0.getXOnScreen();
        c4 = arg0.getYOnScreen();
        try {
            draggedScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Issue is under construction");
    }
}

@Override
public void mouseDragged(MouseEvent arg0) {
    drag_status = 1;
    c3 = arg0.getXOnScreen();
    c4 = arg0.getYOnScreen();
}

@Override
public void mouseMoved(MouseEvent arg0) {
}