import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FocusablePaintComps {
    private static abstract class FocusableComponent extends JComponent {
        @Override protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            if (hasFocus()) {
                final Color prevColor = g.getColor();
                g.setColor(Color.BLUE);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                g.setColor(prevColor);
            }
        }
    }

    private static class FocusableComponent1 extends FocusableComponent {
        @Override protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    private static class FocusableComponent2 extends FocusableComponent {
        @Override protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            final int w = getWidth(), h = getHeight();
            g.fillRect(20, 20, w - 40, h - 40);
            g.fillArc(10, 10, w - 1, h - 1, 60, 150);
        }
    }

    private static class YourPanel extends JPanel {
        private Component previousFocusedComponent = null;

        private YourPanel() {
            super(null); //Null LayoutManager. This is important to be able to
            //move added components around freelly (with the method setBounds(...)).

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(final MouseEvent evt) {
                    final Component src = getComponentAt(evt.getPoint());
                    if (src instanceof FocusableComponent) {
                        final FocusableComponent fc = (FocusableComponent) src;
                        fc.requestFocusInWindow(); //Transfer focus to the pressed component.
                        if (previousFocusedComponent != null)
                            previousFocusedComponent.repaint(); //Repaint the last (without focus now).
                        setComponentZOrder(fc, 0); //Update: To make fc paint over all others as  
                        //the user http://stackoverflow.com/users/131872/camickr commented.  
                        fc.repaint(); //Repaint the new (with focus now).
                        previousFocusedComponent = fc;
                    }
                    else { //If clicked on empty space, or a non-FocusableComponent:
                        requestFocusInWindow(); //Tranfer focus to somewhere else (e.g. the panel itself).
                        if (previousFocusedComponent != null) {
                            previousFocusedComponent.repaint(); //Repaint the last (without focus now).
                            previousFocusedComponent = null;
                        }
                    }
                }
            });

            setPreferredSize(new Dimension(250, 250));

            add(new FocusableComponent1(), Color.RED, new Rectangle(10, 10, 200, 20));
            add(new FocusableComponent1(), Color.GREEN, new Rectangle(40, 150, 50, 70));
            add(new FocusableComponent2(), Color.GRAY, new Rectangle(60, 125, 90, 100));
            add(new FocusableComponent2(), Color.MAGENTA, new Rectangle(150, 60, 80, 150));
        }

        private void add(final FocusableComponent fc, final Color fgColor, final Rectangle bounds) {
            fc.setForeground(fgColor);
            add(fc);
            fc.setBounds(bounds);
        }
    }

    public static void main(final String[] args) {
        final JFrame frame = new JFrame("Focused Paint Comps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new YourPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}