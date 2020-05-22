public class TestPane extends JPanel {

    private int[] xCoordinates = {20, 40, 30};
    private int[] yCoordinates = {40, 40, 60};

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 450, 40);
        g.fillRect(0, 260, 450, 40);

        int[] xPosy = Arrays.copyOf(xCoordinates, xCoordinates.length);
        g.setColor(Color.CYAN);
        for (int index = 0; index < 4; index++) {

            g.fillPolygon(xPosy, yCoordinates, 3);
            xPosy[0] += 95;
            xPosy[1] += 95;
            xPosy[2] += 95;

        }
    }
}