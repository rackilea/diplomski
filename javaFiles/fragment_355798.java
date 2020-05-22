import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author David
 */
public class DragOverMultipleComponentsTest {

    public DragOverMultipleComponentsTest() {
        createAndShowUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DragOverMultipleComponentsTest();
            }
        });
    }

    private void createAndShowUI() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel draggableLabel = new JLabel("<- Drag me");
        JLabel draggableLabel2 = new JLabel("<- Drag me too");

        JLabel labelPanel1 = new JLabel("Drag 'em here");
        JPanel panel1 = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };
        panel1.add(labelPanel1);
        panel1.setName("Droppable");

        JLabel labelPanel2 = new JLabel("Drag 'em here");
        JPanel panel2 = new JPanel();
        panel2.add(labelPanel2);
        panel2.add(draggableLabel);
        panel2.add(draggableLabel2);
        panel2.setName("Droppable");

        JSeparator js = new JSeparator(JSeparator.VERTICAL);

        ComponentDrag cd = new ComponentDrag(frame);

        cd.registerComponent(draggableLabel);
        cd.registerComponent(draggableLabel2);

        frame.add(panel1, BorderLayout.WEST);
        frame.add(js);
        frame.add(panel2, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
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