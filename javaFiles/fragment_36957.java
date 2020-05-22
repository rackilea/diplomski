public class YourFrame extends JFrame { //Replace with your class name, obviously

    public YourFrame(){
        //Create and add trianglePanel
        setLayout(new BorderLayout());
        add(new TrianglePanel(), BorderLayout.CENTER);
        pack();
        repaint();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class TrianglePanel extends JPanel implements MouseListener{
        private Polygon triangle;

        public TrianglePanel(){
            //Create triangle
            triangle = new Polygon();
            triangle.addPoint(150, 200);
            triangle.addPoint(100, 100);
            triangle.addPoint(200, 100);

            //Add mouse Listener
            addMouseListener(this);

            //Set size to make sure that the whole triangle is shown
            setPreferredSize(new Dimension(300, 300));
        }

        /** Draws the triangle as this frame's painting */
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            g2d.draw(triangle);
        }

        //Required methods for MouseListener, though the only one you care about is click
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

        /** Called whenever the mouse clicks.
          * Could be replaced with setting the value of a JLabel, etc. */
        public void mouseClicked(MouseEvent e) {
            Point p = e.getPoint();
            if(triangle.contains(p)) System.out.println("Triangle contains point");
            else System.out.println("Triangle Doesn't contain point");
        }
    }
}