public class LetterDraw extends JPanel {
    private Color color = Color.BLUE; // default;

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ...
        g.setColor(color);
    }
}