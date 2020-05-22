public class Oval extends JPanel {
    private Color color;

    public Oval(Color color) {
        this.color = color.
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
    }

    public void changeColor(Color color) {
        this.color = color;
        repaint();
    }
}