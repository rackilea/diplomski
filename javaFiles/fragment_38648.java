import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    static JFrame frame;
    static JDialog dialog;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }


                frame = new JFrame();
                frame.setSize(600, 600);
                GlassPane frameGlas = new GlassPane(frame);
                frame.setGlassPane(frameGlas);
                frame.setVisible(true);

                frameGlas.setVisible(true);
                dialog = new JDialog(frame);

                dialog.setSize(100, 100);
                GlassPane dialogGlas = new GlassPane(dialog);
                dialog.setGlassPane(dialogGlas);
                dialogGlas.setVisible(true);
                dialog.setVisible(true);

                // Register a listener for the frameGlas
                Toolkit.getDefaultToolkit().addAWTEventListener(
                        frameGlas,
                        AWTEvent.MOUSE_MOTION_EVENT_MASK
                        | AWTEvent.MOUSE_EVENT_MASK);
                // Register a listener for the dialogGlas
                Toolkit.getDefaultToolkit().addAWTEventListener(
                        dialogGlas,
                        AWTEvent.MOUSE_MOTION_EVENT_MASK
                        | AWTEvent.MOUSE_EVENT_MASK);
            }
        });
    }

    public class GlassPane extends JPanel implements AWTEventListener {

        private static final long serialVersionUID = 5110857185182004819L;
        private final Window target;

        public GlassPane(Window target) {
            super(null);
            this.target = target;

        }

        @Override
        public void eventDispatched(AWTEvent event) {
            if (event instanceof MouseEvent) {

                MouseEvent originalEvent = (MouseEvent) event;

                MouseEvent e = originalEvent;
                Component source = e.getComponent();
                System.out.println("Source: " + source);
                System.out.println("Target: " + target);
                if (target != null && target.equals(source)) {
                    e = SwingUtilities.convertMouseEvent(
                            ((MouseEvent) event).getComponent(),
                            (MouseEvent) event, this);

                    if (e.getID() == MouseEvent.MOUSE_PRESSED) {

                        Point p = target.getLocationOnScreen();
                        System.out.println(p.getX());
                    }
                }
            }
        }
    }
}