import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private GridPane gridPane;
    private DragPanel drag;
    public boolean isMouseClicked = false;
    public static JMenuBar bar = new JMenuBar();
    public int gridY = 1;
    public int gridX = 1;
    public int x = 0, y = 0;

    public Game() {
        setLayout(new BorderLayout());

        OptionPanel options = new OptionPanel();
        options.addActionListener(this);
        add(options, BorderLayout.NORTH);

        gridPane = new GridPane();
        gridPane.setBorder(BorderFactory.createLineBorder(Color.white));
        add(gridPane);

        drag = new DragPanel(options);
        drag.setBorder(BorderFactory.createLineBorder(Color.white));
        drag.setBackground(new Color(100, 100, 125));
        add(drag, BorderLayout.WEST);
    }

    public static void main(String args[]) {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        if (e.getActionCommand().equalsIgnoreCase("grid")) {
            gridPane.setGridOn(!gridPane.isGridOn());
        }

        if (e.getActionCommand().equalsIgnoreCase("square")) {
            gridPane.setSqaureOn(!gridPane.isSquareOn());
        }
        if (e.getActionCommand().equalsIgnoreCase("vgrid")) {
            gridPane.setVertOn(!gridPane.isVertOn());
        }
    }

    public class GridPane extends JPanel {

        private static final long serialVersionUID = 1L;
        private boolean gridOn = false;
        private boolean squareOn = false;
        private boolean vertOn = false;

        public GridPane() {
            setBackground(Color.BLACK);
        }

        public boolean isGridOn() {
            return gridOn;
        }

        public boolean isSquareOn() {
            return squareOn;
        }

        public boolean isVertOn() {
            return vertOn;
        }

        public void setGridOn(boolean value) {
            if (value != gridOn) {
                this.gridOn = value;
                repaint();
            }
        }

        public void setVertOn(boolean value) {
            if (value != vertOn) {
                this.vertOn = value;
                repaint();
            }
        }

        public void setSqaureOn(boolean value) {
            if (value != squareOn) {
                this.squareOn = value;
                repaint();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(320, 240);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Toolkit tk = Toolkit.getDefaultToolkit();
            if (gridOn) {
                System.out.println("Grid works");
                g.setColor(Color.white);
                for (int i = 0; i < tk.getScreenSize().height; i += 64) {
                    gridY++;
                    g.drawLine(0, (64 * gridY), tk.getScreenSize().width, (64 * gridY));
                }
            }
            gridY = -1;
            gridX = -1;
            if (vertOn) {
                System.out.println("vert grid works");
                g.setColor(Color.white);
                for (int ig = 0; ig < tk.getScreenSize().width; ig += 64) {
                    gridX++;
                    g.drawLine((64 * gridX), 0, (64 * gridX), tk.getScreenSize().height);
                }
            }
            if (squareOn) {
                System.out.println("Square works");
                g.setColor(Color.red);
                g.fillRect(0, 0, 64, 64);
            }
        }
    }

    public class DragPanel extends JPanel {

        OptionPanel op;

        public DragPanel(OptionPanel op) {
            this.op = op;
            this.add(this.op.squareButton);
            this.op.squareButton.setActionCommand("square");
        }

        public void addActionListener(ActionListener listener) {
            System.out.println(listener);
            this.op.squareButton.addActionListener(listener);
        }
    }

    private static class Square {
    }

    private class OptionPanel extends JPanel {

        public JButton grid;
        public JButton vgrid;
        public JButton squareButton;
        public JTextField squareX;
        public JTextField squareY;
        public JTextField squareW;
        public JTextField squareH;
        public Square square = new Square();

        public OptionPanel() {

            //Sets the stuff for the panel
            setBackground(new Color(155, 0, 255));
            setLayout(new GridBagLayout());
            //end

            //The Show Grid Button Stuff
            grid = new JButton("Show Horizontal Grid");
            grid.setActionCommand("grid");
            //end

            //The vertical grid
            vgrid = new JButton("Show Vertical Grid");
            vgrid.setActionCommand("vgrid");
            //end

            //The Square tool button stuff
            squareButton = new JButton("Sqaure Tool");

            //end

            squareX = new JTextField(3);
            squareY = new JTextField(3);
            squareW = new JTextField(3);
            squareH = new JTextField(3);

            //The gridbagConstraints things
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTH;


            //kind of like padding
            gbc.weighty = 1;

            //sets the positions
            gbc.gridx = 0;
            gbc.gridy = 0;

            //add it
            add(grid, gbc);

            //changes position for the second button
            gbc.gridx = -1;
            gbc.gridy = 0;

            // adds it
            add(vgrid, gbc);

            //end

            add(squareX, gbc);
            add(squareY, gbc);
            add(squareW, gbc);
            add(squareH, gbc);
        }

        public void addActionListener(ActionListener listener) {
            //adds action listeners
            grid.addActionListener(listener);
            vgrid.addActionListener(listener);
            squareButton.addActionListener(listener);
            System.out.println(listener);
        }
    }
}