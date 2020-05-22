import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

// import net.miginfocom.swing.MigLayout;

public class TestScrollPane extends MouseInputAdapter {
   public void mouseEntered(MouseEvent arg0) {
      System.out.println("Entered " + arg0.getComponent());
   }

   public void mouseExited(MouseEvent arg0) {
      System.out.println("Exited " + arg0.getComponent());
   }

   public void mousePressed(MouseEvent arg0) {
      System.out.println("Pressed " + arg0.getComponent());
   }

   public void mouseReleased(MouseEvent arg0) {
      System.out.println("Released " + arg0.getComponent());
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame();
      // frame.setLayout(new MigLayout());
      frame.getContentPane().setLayout(new FlowLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      TestPane pane1 = new TestPane("Scroll Pane 1");
      TestPane pane2 = new TestPane("Scroll Pane 2");
      frame.add(pane1, "push,grow");
      frame.add(pane2, "push, grow");
      // !! TestMouseListener listener = new TestMouseListener();
      TestScrollPane listener = new TestScrollPane();
      pane1.addMouseListener(listener);
      pane1.addMouseMotionListener(listener);
      pane2.addMouseListener(listener);
      pane2.addMouseMotionListener(listener);
      frame.pack();
      frame.setVisible(true);

      Toolkit.getDefaultToolkit().addAWTEventListener(
            listener.createAWTWindowListener(), AWTEvent.MOUSE_EVENT_MASK);

   }

   private AWTEventListener createAWTWindowListener() {
      AWTEventListener awt1 = new AWTEventListener() {

         @Override
         public void eventDispatched(AWTEvent e) {
            if (MouseEvent.MOUSE_PRESSED == e.getID()) {
               MouseEvent event = (MouseEvent) e;
               Component comp = event.getComponent();

               if (comp != null) {
                  String scrollPanelName = recursivelyCheckForScrollPanel(comp);
                  if (scrollPanelName != null) {
                     System.out.println("TestPane pressed. Name: " + scrollPanelName);
                  } else {
                     System.out.println("TestPane not pressed");
                  }
               }
            }
         }

         private String recursivelyCheckForScrollPanel(Component comp) {
            if (comp instanceof TestPane) {
               return comp.toString();
            } else {
               comp = comp.getParent();
               if (comp != null) {
                  return recursivelyCheckForScrollPanel(comp);
               }
            }
            return null;
         }
      };
      return awt1;
   }
}

class TestPanel2 extends JPanel {
   String name;

   TestPanel2(String name) {
      this.name = name;
      // setLayout(new MigLayout());
      JTextArea area = new JTextArea(5, 20);
      area.append(name);
      add(area, "push, grow");
   }

   public String toString() {
      return name;
   }
}

class TestPane extends JScrollPane {
   String name;

   TestPane(String name) {
      this.name = name;
      TestPanel2 panel = new TestPanel2(name + " panel");
      setViewportView(panel);
   }

   public String toString() {
      return name;
   }
}