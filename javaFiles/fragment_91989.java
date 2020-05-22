public class Planets extends JPanel {
    private List<StellarObject> stellarObjects = new LinkedList<>();
    private Timer timer;
    private StellarObject sun = new StellarObject(0, 0, new Color(255, 255, 0), 70);
    private StellarObject mercury = new StellarObject(9, 0.07, new Color(255, 0, 0), 5);
    private StellarObject venus = new StellarObject(8, 0.05, new Color(153, 76, 0), 10);

    public Planets(){
        super();
        timer = new Timer(100, e -> update());
        timer.start();
        setBackground(Color.BLACK);
        Collections.addAll(stellarObjects, sun, mercury, venus);
    }

    public void update() {
        stellarObjects.forEach(StellarObject::update);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (StellarObject stellarObject : stellarObjects) {
            stellarObject.draw(g);
        }
    }

    public class StellarObject {
        private int distance;
        private double angle;
        private double angularVelocity;
        private Color color;
        private int radius;

        public StellarObject(int distance, double angularVelocity, Color color, int radius) {
            this.distance = distance;
            this.angularVelocity = angularVelocity;
            this.color = color;
            this.radius = radius;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(xDelta() - radius / 2, yDelta() - radius / 2, radius, radius);
        }

        private void update() {
            angle += angularVelocity;
            angle %= 2 * Math.PI;
        }

        public int xDelta() {
            return (int) ((distance == 0 ? 0 : Math.cos(angle) * (getWidth() / distance)) + (getWidth() / 2));
        }

        public int yDelta() {
            return (int) ((distance == 0 ? 0 : Math.sin(angle) * (getHeight() / distance)) + (getHeight() / 2));
        }
    }
}