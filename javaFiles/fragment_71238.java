public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame();
            Plane plane = new Plane();
            frame.add(plane);
            plane.setBackground(Color.WHITE);
            plane.addBody(new Body(10.0, new Point(10, 10), new Vector(0, 0), Color.GREEN));

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Orbit");
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

@SuppressWarnings("serial")
class Plane extends JPanel {

    private HashSet<Body> bodies = new HashSet<>();

    public void addBody(Body body) {

        bodies.add(body);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Body body : bodies) {
            // Might want to call all needed accessors before getting to work.
            g.setColor(body.getColor());
            g.fillOval(body.getLocation().x, body.getLocation().y, getWidth(), getHeight());
        }
    }

    @Override
    public Dimension getPreferredSize() {

        // Calculate the size
        return new Dimension(1000, 500);
    }
}

class Body {

    private Point location;
    private Vector velocity;
    private Color color;

    public Body(double mass, Point location, Vector velocity, Color color) {

        this.location = location;
        this.velocity = velocity;
        this.color = color;
    }

    public Point getLocation() {

        return location;
    }

    public Color getColor() {

        return color;
    }
}