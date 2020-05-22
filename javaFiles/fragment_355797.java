import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DragButtonsTest {

    ArrayList<JButton> buttons = new ArrayList<>();

    public DragButtonsTest() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel(new GridLayout(2, 2));

        ComponentDrag cd = new ComponentDrag(frame) {
            @Override
            protected void componentDropped(MouseEvent me) {
                HashMap<Integer, JButton> collisions = new HashMap<>();
                JButton draggedButton = (JButton) me.getSource();

                for (JButton btn : buttons) {//iterate through all buttons and get the number of collsions of each
                    if (btn != draggedButton) {//dont chck button we were dragging
                        int col = checkPerPixelCollision(draggedButton, btn);
                        System.out.println("Button " + btn.getText());
                        System.out.println(col);
                        collisions.put(col, btn);
                    }
                }

                //lets get the button which had most collisions
                int maxCollisions = 0;
                JButton intersectingButton = null;
                for (Map.Entry<Integer, JButton> entry : collisions.entrySet()) {
                    Integer collisionCount = entry.getKey();
                    JButton button = entry.getValue();
                    if (collisionCount > maxCollisions) {
                        maxCollisions = collisionCount;
                        intersectingButton = button;
                    }
                }

                boolean reLayout = false;

                if (maxCollisions > 0) {//check if there was any
                    System.out.println("Button " + draggedButton.getText() + " is intersecting more of Button " + intersectingButton.getText());
                    System.out.println("Collisions: " + maxCollisions);
                    reLayout = true;
                } else {
                    System.out.println("No change made");
                    reLayout = false;
                }

                ArrayList<JButton> tmpButtons = (ArrayList<JButton>) buttons.clone();//create clone of buttons

                if (reLayout) {//a button as moved and panel needs to be layed out
                    buttons.clear();//clear old buttons

                    for (JButton b : tmpButtons) {//re-order jbuttons
                        if (b == intersectingButton) {
                            buttons.add(draggedButton);
                        } else if (b == draggedButton) {
                            buttons.add(intersectingButton);
                        } else {
                            buttons.add(b);
                        }
                    }
                    panel.removeAll();//remove all buttons
                    for (JButton btn : buttons) {//iterate through all buttons and get the number of collsions of each
                        panel.add(btn);//re-add buttons according to arraylist
                    }
                    panel.revalidate();
                    panel.repaint();
                }
                super.componentDropped(me);

            }
        };

        for (int i = 0; i < 4; i++) {
            JButton b = new JButton(String.valueOf(i + 1));
            panel.add(b);
            buttons.add(b);
            cd.registerComponent(b);
        }

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DragButtonsTest();
            }
        });
    }

    public HashSet<String> getMask(JButton e) {
        HashSet<String> mask = new HashSet<>();
        int pixel, a;
        BufferedImage bi = componentToImage(e); //gets the current image being shown

        for (int i = 0; i < bi.getWidth(); i++) { // for every (x,y) component in the given box, 
            for (int j = 0; j < bi.getHeight(); j++) {
                pixel = bi.getRGB(i, j); // get the RGB value of the pixel
                a = (pixel >> 24) & 0xff;
                if (a != 0) {  // if the alpha is not 0, it must be something other than transparent
                    mask.add((e.getX() + i) + "," + (e.getY() - j)); // add the absolute x and absolute y coordinates to our set
                }
            }
        }
        return mask;  //return our set
    }

    public static BufferedImage componentToImage(Component component) {
        BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics g = img.getGraphics();
        component.paintAll(g);
        return img;
    }

    // Returns true if there is a collision between object a and object b   
    public int checkPerPixelCollision(JButton b, JButton b2) {
        // This method detects to see if the images overlap at all. If they do, collision is possible
        int ax1 = (int) b2.getX();
        int ay1 = (int) b2.getY();

        int ax2 = ax1 + (int) b2.getWidth();
        int ay2 = ay1 + (int) b2.getHeight();

        int bx1 = (int) b.getX();
        int by1 = (int) b.getY();

        int bx2 = bx1 + (int) b.getWidth();

        int by2 = by1 + (int) b.getHeight();

        if (by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1) {
            return 0; // Collision is impossible.
        } else { // Collision is possible.
            // get the masks for both images
            HashSet<String> maskPlayer1 = getMask(b2);
            HashSet<String> maskPlayer2 = getMask(b);
            maskPlayer1.retainAll(maskPlayer2);  // Check to see if any pixels in maskPlayer2 are the same as those in maskPlayer1
            if (maskPlayer1.size() > 0) {  // if so, than there exists at least one pixel that is the same in both images, thus
                return maskPlayer1.size();
            }
        }
        return 0;
    }
}

class ComponentDrag {

    private MouseAdapter ma;
    private ArrayList<JComponent> components = new ArrayList<>();
    private int startingX, startingY;
    private boolean autoLayout = true;
    private final JFrame container;
    private JPanel glassPane;
    boolean firstTime = true;
    private JComponent lastClickedContainer;

    public ComponentDrag(final JFrame container) {
        this.container = container;
        glassPane = new JPanel();
        glassPane.setOpaque(false);
        glassPane.setLayout(null);
        this.container.setGlassPane(glassPane);

        new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (container.isVisible()) {
                    glassPane.setVisible(true);
                    ((Timer) ae.getSource()).stop();
                }
            }
        }).start();

        ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                super.mousePressed(me);
                componentPressed(me);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                super.mouseReleased(me);
                componentDropped(me);
            }

            @Override
            public void mouseDragged(MouseEvent me) {
                super.mouseDragged(me);
                componentDragged(me);
            }
        };
    }

    public JComponent findDroppableUnderGlassPane(Point p, Container container, Component source) {
        JComponent c = null;
        Component[] comps = container.getComponents();
        for (Component com : comps) {
            if (com.getName() != null) {
                if (com.getName().equals("Droppable") && com instanceof JComponent) {
                    if (com.contains(SwingUtilities.convertPoint(source, p, com))) {
                        return (JComponent) com;
                    }
                } else if (com instanceof Container) {
                    findDroppableUnderGlassPane(p, (Container) com, source);
                }
            }
        }
        return c;
    }

    public boolean isAutoLayout() {
        return autoLayout;
    }

    public void setAutoLayout(boolean autoLayout) {
        this.autoLayout = autoLayout;
    }

    protected void componentDropped(MouseEvent me) {
        firstTime = true;
        Component droppedComponent = (Component) me.getSource();
        droppedComponent.setCursor(null);

        JComponent jc = findDroppableUnderGlassPane(me.getPoint(), container.getContentPane(), (Component) me.getSource());

        if (jc != null) {
            glassPane.removeAll();
            glassPane.revalidate();
            glassPane.repaint();

            jc.add(droppedComponent);
            System.out.println("Removed from glasspane and added to: " + jc);

            if (autoLayout) {
                if (lastClickedContainer != null) {
                    lastClickedContainer.revalidate();
                    lastClickedContainer.repaint();
                }
                droppedComponent.revalidate();
                droppedComponent.repaint();
                jc.revalidate();
                jc.repaint();
            }

        } else {
            glassPane.removeAll();
            glassPane.revalidate();
            glassPane.repaint();
            if (lastClickedContainer != null) {
                lastClickedContainer.add(droppedComponent);
                lastClickedContainer.revalidate();
                lastClickedContainer.repaint();
            }
        }
    }

    protected void componentPressed(MouseEvent me) {
        JComponent jc = findDroppableUnderGlassPane(me.getPoint(), container.getContentPane(), (Component) me.getSource());

        if (jc != null && jc.getName().equals("Droppable")) {
            lastClickedContainer = jc;
            System.out.println("Pressed: " + lastClickedContainer);
        }

        boolean clickedRegisteredComponent = false;

        Component clickedComponent = (Component) me.getSource();

        for (Component component : ComponentDrag.this.components) {
            if (component.equals(clickedComponent)) {
                clickedRegisteredComponent = true;
                break;
            }
        }

        if (clickedRegisteredComponent) {
            startingX = me.getX();
            startingY = me.getY();
            clickedComponent.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }
    }

    protected void componentDragged(MouseEvent me) {
        Component draggedComponent = (Component) me.getSource();

        if (firstTime && lastClickedContainer != null) {
            firstTime = false;
            lastClickedContainer.remove(draggedComponent);
            lastClickedContainer.revalidate();
            lastClickedContainer.repaint();
            glassPane.add(draggedComponent);
            glassPane.revalidate();
            glassPane.repaint();
            System.out.println("Removed from: " + lastClickedContainer + " \nAnd added to glasspane for dragging");
        }

        //MouseEvent will refire on each drag with the position being relative to the firing Component
        draggedComponent.setLocation((me.getX() - startingX) + draggedComponent.getLocation().x, (me.getY() - startingY) + draggedComponent.getLocation().y);
    }

    void registerComponent(JComponent draggableComp) {
        draggableComp.addMouseListener(ma);
        draggableComp.addMouseMotionListener(ma);
        components.add(draggableComp);
    }

    void deregisterComponent(JComponent draggableComp) {
        draggableComp.removeMouseListener(ma);
        draggableComp.removeMouseMotionListener(ma);
        components.remove(draggableComp);
    }
}