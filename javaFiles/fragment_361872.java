public class Circle1 extends JPanel {

    private final CircleCanvas theCanvas;

    private final JTextArea display;

    public Circle1() {

        setLayout(new BorderLayout());

        theCanvas = new CircleCanvas();

        display = new JTextArea(4, 30);

        display.setText("The Radius: " + theCanvas.getRadius() + "\nThe Diameter: " + theCanvas.getDiameter() + "\nThe Area: " + theCanvas.getArea()
                        + "\nThe Circumference: " + theCanvas.getCircumference());

        add(theCanvas, BorderLayout.CENTER);
        add(display, BorderLayout.SOUTH);

    }

    void setDiameter(int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class CircleCanvas extends JPanel {

        private final int radius;

        public CircleCanvas() {

            radius = (int) (1 + Math.random() * 100);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(0, 0, radius, radius);
        }

        public int getDiameter() {
            return (2 * radius);
        }

        public int getCircumference() {
            return (int) (2 * Math.PI * radius);
        }

        public int getArea() {
            return (int) (radius * radius * Math.PI);
        }

        public int getRadius() {
            return radius;
        }

    }
}