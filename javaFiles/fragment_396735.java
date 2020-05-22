@SuppressWarnings("serial")
class BarChart2 extends JPanel {
    private static final double BAR_WIDTH = 0.90;
    private int prefW;
    private int prefH;
    private static final Color BAR_COLOR = Color.RED;
    private int[] data;
    private int maxValue;

    public BarChart2(int[] data, int maxValue, int prefW, int prefH) {
        setData(data, maxValue);
        this.prefW = prefW;
        this.prefH = prefH;
    }

    public final void setData(int[] data, int maxValue) {
        this.data = data;
        this.maxValue = maxValue;
        repaint();
    }

    public int[] getData() {
        return data;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(BAR_COLOR);

        // simple algebraic calculations on where to place the bars
        double denom = data.length + 1 - BAR_WIDTH;
        int barWidth = (int) ((getWidth() * BAR_WIDTH) / denom);  

        for (int i = 0; i < data.length; i++) {
            int x = (int) (getWidth() * (i + 1 - BAR_WIDTH) / denom);
            int height = (int) (getHeight() * data[i] / (double) maxValue);
            int y = (int) (getHeight() - height);
            g.fillRect(x, y, barWidth, height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(prefW, prefH);
    }

}