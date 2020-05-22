public class ChartTableDialog extends JDialog {
    private int[][] data;

    public ChartTableDialog(final JFrame frame, boolean modal, int[][] data) {
        super(frame, model);
        this.data = data;
    }

    // somewhere else in the code you will use data[][] for formulate
    // your chart and your table
}