public class CraneSimulator {
    ...
    private JFrame frame = new JFrame("CraneSimulator");
    private MyPanel panel = new JPanel();

    public CraneSimulator() {
        ...
        frame.add(panel);
    }
    public static void main(String[] args) {
        CraneSimulator simulator = new CraneSimulator();    
    }
}   

class MyPanel extends JPanel {
    CraneBody body = new CraneBody();
    CraneArm arm1 = new CraneArm(body);
    ...
    MouseAdapter mAdapter = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            ...
        }
        public void mouseReleased(MouseEvent e) {
            ...
        }
        public void mouseDragged(MouseEvent e) {
            ...             
        }
    }

    public MyPanel() {
        ...
        addMouseListener(mAdapter);
        addMouseMotionListener(mAdapter);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        ...
        body.paint(graphics);
        arm1.paint(graphics);  
    }
}

class CraneBody {
    ...
    public CraneBody() {
         ....
    }
    ...
    public void paint(Graphics2D g) {
        // You don't need to cast a Graphics again.      
    }
}

class CraneArm {
    ...
    public CraneArm() {
         ....
    }
    ...
    public void paint(Graphics2D g) {
        // You don't need to cast a Graphics again.
    }
}