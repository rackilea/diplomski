import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFrame extends JFrame {

    private final int WIDTH = 500;
    private final int HEIGHT = 300;

//  private GUIModel model;
    private JButton number1;
    private JButton number2;

    private JPanel numberPanel;
    private DrawPanel graphicsPanel;

    public DrawFrame() {
//      this.model = new GUIModel(" ");

        createSelectionPanel();
        createGraphicsPanel();

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void createSelectionPanel() {
        numberPanel = new JPanel();

        ButtonListener listener = new ButtonListener();

        number1 = new JButton("A");
        number1.addActionListener(listener);

        number2 = new JButton("B");
        number2.addActionListener(listener);

        numberPanel.setLayout(new GridLayout(2, 2));
        numberPanel.add(number1);
        numberPanel.add(number2);

        this.add(numberPanel, BorderLayout.WEST);
    }

    private void createGraphicsPanel() {
        //instantiate drawing panel
        graphicsPanel = new DrawPanel(WIDTH, HEIGHT);
        //add drawing panel to right
        add(graphicsPanel);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            graphicsPanel.setDisplayString(event.getActionCommand());
        }
    }

    //creates a drawing frame
    public static void main(String[] args) {
        DrawFrame draw = new DrawFrame();
    }

    public static class DrawPanel extends JPanel {

        private static final long serialVersionUID = 3443814601865936618L;

        private Font font = new Font("Default", Font.BOLD, 30);

        private static final Color DEFAULT_TEXT_COLOR = Color.BLACK;
        private static final Color HOVER_TEXT_COLOR = Color.RED;
        private Color color = DEFAULT_TEXT_COLOR;

        private List<GUIModel> numberList = new ArrayList<GUIModel>();
        boolean mouseHover = false;

        private String displayString;
        private GUIModel hoverModel;

        public DrawPanel(int width, int height) {
            this.setPreferredSize(new Dimension(width, height));

            //set white background for drawing panel
            setBackground(Color.WHITE);

            //add mouse listeners
            MouseHandler mouseHandler = new MouseHandler();
            this.addMouseListener(mouseHandler);
            this.addMouseMotionListener(mouseHandler);
        }

        protected Rectangle getBounds(GUIModel model) {
            FontMetrics metrics = getFontMetrics(font);
            Double x = model.getCoordinate().getX();
            Double y = model.getCoordinate().getY();

            Rectangle textBounds = new Rectangle(
                    x.intValue(),
                    y.intValue(),
                    metrics.stringWidth(model.getDisplayString()),
                    metrics.getHeight());
            return textBounds;
        }

        void checkForHover(MouseEvent event) {

            Rectangle textBounds = null;
            if (hoverModel != null) {
                textBounds = getBounds(hoverModel);
            }
            hoverModel = null;
            if (textBounds != null) {
                repaint(textBounds);
            }
            for (GUIModel model : numberList) {

                textBounds = getBounds(model);

                if (textBounds.contains(event.getPoint())) {
                    hoverModel = model;
                    repaint(textBounds);
                    break;
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(font);
            g.setColor(DEFAULT_TEXT_COLOR);

            FontMetrics fm = g.getFontMetrics();
            for (GUIModel model : numberList) {
                if (model != hoverModel) {
                    Double x = model.getCoordinate().getX();
                    Double y = model.getCoordinate().getY();
                    String display = model.getDisplayString();
                    g.drawString(display, x.intValue(), y.intValue() + fm.getAscent());
                }
            }
            if (hoverModel != null) {
                g.setColor(HOVER_TEXT_COLOR);
                Double x = hoverModel.getCoordinate().getX();
                Double y = hoverModel.getCoordinate().getY();
                String display = hoverModel.getDisplayString();
                g.drawString(display, x.intValue(), y.intValue() + fm.getAscent());
            }

//          if (model.getCoordinate() != null) {
//              Point p = model.getCoordinate();
//              g.drawString(model.getDisplayString(), p.x, p.y);
////                GUIModel number = new GUIModel();
////                number.setCoordinate(p);
////                number.setDisplayString(model.getDisplayString());
////                numberList.add(number);
//          }
        }

        public void setDisplayString(String text) {
            displayString = text;
        }

        //class to handle all mouse events
        private class MouseHandler extends MouseAdapter implements MouseMotionListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                GUIModel model = new GUIModel(displayString);
                model.setCoordinate(e.getPoint());
                numberList.add(model);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent event) {
                checkForHover(event);
            }
        }
    }

    public static class GUIModel {

        private String displayString;
        private Point coordinate;

        public GUIModel() {
        }

        public GUIModel(String displayString) {
            this.displayString = displayString;
        }

        public void setDisplayString(String displayString) {
            this.displayString = displayString;
        }

        public String getDisplayString() {
            return displayString;
        }

        public Point getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(int x, int y) {
            this.coordinate = new Point(x, y);
        }

        public void setCoordinate(Point coordinate) {
            this.coordinate = coordinate;
        }
    }
}