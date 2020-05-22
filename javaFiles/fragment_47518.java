import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class MyShapes extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private JMenuBar menuBar = new JMenuBar();
    private Color color = Color.WHITE;

    public MyShapes() {
        JMenu colorMenu = new JMenu("Color");
        colorMenu.add(new JMenuItem(new ColorAction("Black", Color.BLACK)));
        colorMenu.add(new JMenuItem(new ColorAction("White", Color.WHITE)));
        colorMenu.add(new JMenuItem(new ColorAction("Red", Color.RED)));
        colorMenu.add(new JMenuItem(new ColorAction("Blue", Color.BLUE)));
        colorMenu.add(new JMenuItem(new ColorAction("Green", Color.GREEN)));
        menuBar.add(colorMenu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private class ColorAction extends AbstractAction {
        private Color actionColor;

        public ColorAction(String name, Color color) {
            super(name);
            this.actionColor = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            color = actionColor;
            repaint();
        }
    }

    private static void createAndShowGui() {
        MyShapes mainPanel = new MyShapes();

        JFrame frame = new JFrame("MyShapes");
        frame.setJMenuBar(mainPanel.getMenuBar());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}