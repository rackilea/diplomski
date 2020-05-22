import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test extends JPanel implements ActionListener {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Test());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    Timer t = new Timer(5, this);
    int x = 20, y = 20, vely = 1;

    public Test() {
        t.start();

        addKeyBinding("space.pressed", KeyEvent.VK_SPACE, true, new ChangeYAction(-1));
        addKeyBinding("space.released", KeyEvent.VK_SPACE, false, new ChangeYAction(1));
    }

    protected void addKeyBinding(String name, int virtualKey, boolean pressed, Action action) {
        addKeyBinding(name, KeyStroke.getKeyStroke(virtualKey, 0, !pressed), action);
    }

    protected void addKeyBinding(String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, 5, 5);
    }

    public void actionPerformed(ActionEvent e) {

        if (y < 0) {
            vely = 0;
            y = 0;
        }

        if (y > 305) //-70
        {
            vely = 0;
            y = 305;
        }

        y += vely;
        repaint();
    }

    public class ChangeYAction extends AbstractAction {

        private int changeYTo;

        public ChangeYAction(int changeYTo) {
            this.changeYTo = changeYTo;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            vely = changeYTo;
        }

    }

}