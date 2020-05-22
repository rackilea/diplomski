public class ChartComponent extends JComponent {
    private final int[] values; // For example

    public ChartComponent(int[] values) {
        this.values = values;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
    }
}