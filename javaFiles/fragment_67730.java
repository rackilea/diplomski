public class Circle extends JFrame {

    public Circle() {
        setSize(400, 400);
        add(new CirclePanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Circle c = new Circle();
    }
}

class CirclePanel extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(0, 0, getWidth(), getHeight());  
    }
}