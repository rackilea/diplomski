public class Labyrinth extends JPanel {

    private final ArrayList<Line> lines = new ArrayList<Line>();

    public void addLine(int x1, int y1, int x2, int y2) {
        this.lines.add(new Line(x1, y1, x2, y2));
    }

    public void paintComponent(Graphics g) {
        for(final Line r : lines) {
            r.paint(g);
        }
    }
}

public static class Line {
    public final int x1;
    public final int x2;
    public final int y1;
    public final int y2;
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void paint(Graphics g) {
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}