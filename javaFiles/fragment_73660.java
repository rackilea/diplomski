import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GUI
{
    private final ButtonGroup colorGroup; //group  buttons
    private final ButtonGroup shapeGroup; //so only one can be selected at any given time
    private final Map<String, Color> colors; //map colors to it names.
    private Color color; // color for painting
    private Shape shape; //shape to paint
    private JFrame frame;
    private JPanel buttonsPane;
    private JTextArea textArea;

    private static final int ROWS = 2, COLS = 3;
    private static final String[] BUTTONS_LABELS = {"Rectangle", "Circle", "Exit"};

    public GUI()
    {
        shapeGroup = new ButtonGroup(); colorGroup = new ButtonGroup();
        colors = new HashMap<>();
        colors.put("Red", Color.RED); colors.put("Green", Color.GREEN); colors.put("Blue", Color.BLUE);
    }

    private void createAndShowGUI(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //use a GridLayout for the buttons pane
        buttonsPane = new JPanel();
        buttonsPane.setLayout(new GridLayout(ROWS, COLS));
        frame.getContentPane().add(buttonsPane, BorderLayout.CENTER);//each BorderLayout position can hold ONE component

        for(String colorName : colors.keySet()){
            JToggleButton button = makeButton(colorName);
            buttonsPane.add(button);
            colorGroup.add(button);
            button.addActionListener(changeColorAction());
        }

        for(String text : BUTTONS_LABELS){
            JToggleButton button = makeButton(text);
            buttonsPane.add(button);
            shapeGroup.add(button);
            button.addActionListener(changeShapeAction());
        }

        setDefaults();

        frame.getContentPane().add(new Draw(), BorderLayout.WEST);
        textArea = new JTextArea(0,20);
        frame.getContentPane().add(textArea, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    private JToggleButton makeButton(String text) {
        JToggleButton b = new JToggleButton(text); //use toggle buttons
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setPreferredSize(new Dimension(100, 80)); //set preferred and let Layout manager do its work
        return b;
    }

    private ActionListener changeColorAction() {
        return e->{
            color = colors.get(((JToggleButton)e.getSource()).getText());
            frame.repaint();
        };
    }

    private ActionListener changeShapeAction() {
        return e->{
            switch (((JToggleButton)e.getSource()).getText()){

                case "Circle":
                    shape = Shape.CIRCLE;
                    break;
                case "Rectangle":
                    shape = Shape.RECTANGLE;
                    break;
                default: System.exit(0);
            }

            frame.repaint();
        };
    }

    private void setDefaults() {
        colorGroup.getElements().nextElement().setSelected(true);
        color = colors.get(colorGroup.getElements().nextElement().getText());
        shapeGroup.getElements().nextElement().setSelected(true);
        shape = Shape.RECTANGLE;
    }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new GUI().createAndShowGUI("My Gui"));
        }

    class Draw extends JPanel{

        private final Point[] points; // an array to hold clicked points
        private int mouseClicks = 0;
        private static final int POINT_SIZE = 2;

        Draw(){
            setLayout(new BorderLayout());
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(200, 200));

            JLabel help = new JLabel("Click 2 points to draw");
            help.setHorizontalAlignment(SwingConstants.CENTER);
            add(help, BorderLayout.PAGE_START);

            JLabel timeLabel = new JLabel("current time here");
            timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
            add(timeLabel, BorderLayout.PAGE_END);

            points = new Point[2];
            addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    addPoint(e.getX(), +e.getY() );
                }
            });
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(color);
            for(Point point : points)
                if(point != null){
                    g.drawOval(point.x, point.y, POINT_SIZE, POINT_SIZE);
                }

            drawShape((Graphics2D)g);
        }

        private void addPoint(int x, int y) {
            if(mouseClicks ==2){
                mouseClicks = 0;
                points[1] = null;
            }

            points[mouseClicks++] = new Point(x, y);
            repaint();
        }

        private void drawShape(Graphics2D g2d) {

            if(points[0] == null ||  points[1] == null) return;
            if(shape == Shape.RECTANGLE) {
                drawRectangle(g2d);
            }else{
                drawCircle(g2d);
            }
        }

        private void drawRectangle(Graphics2D g2D) {

            int minX = Math.min(points[0].x, points[1].x);
            int minY = Math.min(points[0].y, points[1].y);
            int maxX = Math.max(points[0].x, points[1].x);
            int maxY = Math.max(points[0].y, points[1].y);
            int width  = maxX - minX;
            int height = maxY - minY;
            Rectangle2D.Double rectangle = new Rectangle2D.Double(minX, minY, width, height);
            g2D.draw(rectangle);
        }

        private void drawCircle(Graphics2D g2D) {

            int minX = Math.min(points[0].x, points[1].x);
            int minY = Math.min(points[0].y, points[1].y);
            int maxX = Math.max(points[0].x, points[1].x);
            int maxY = Math.max(points[0].y, points[1].y);
            double dx  = maxX - minX;
            double dy = maxY - minY;
            double radius =  Math.sqrt(dx*dx + dy*dy)/2;
            double centerX = minX + dx/2;
            double centerY = minY + dy/2;

            g2D.draw(new Ellipse2D.Double(centerX - radius , centerY - radius, 2* radius, 2* radius));
        }
    }

    enum Shape {
        RECTANGLE, CIRCLE
    }
}