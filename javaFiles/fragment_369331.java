public class RubberLinesPanel extends JPanel {
    private Point current = null, point2 = null;
    private double length;
    private double totalDistance = 0.0;  // ***** add this *****
    private DecimalFormat fmt;

    public RubberLinesPanel() {
        // .... etc .....
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(Color.yellow);
        if (current != null && point2 != null)
            page.drawLine(current.x, current.y, point2.x, point2.y);
        page.drawString("Distance: " + fmt.format(length), 10, 15);

        // draw totalDistance here  // ************ draw it here
    }

    private class LineListener implements MouseListener, MouseMotionListener {

        public void mousePressed(MouseEvent event) {
            current = event.getPoint();
        }

        public void mouseDragged(MouseEvent event) {
            point2 = event.getPoint();
            length = Math.sqrt(Math.pow((current.x - point2.x), 2)
                    + Math.pow((current.y - point2.y), 2));
            totalDistance += length;   // ******* calculate it here
            repaint();
        }