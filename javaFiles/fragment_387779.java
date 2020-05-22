import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @see https://stackoverflow.com/a/40445144/230513
 */
public class ChartTable {

    private static final Random R = new Random();
    private static final int N = 5000;
    private static final int W = 200;
    private static final int H = W;

    private void display() {
        JFrame f = new JFrame("ChartTable");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"", "", "", ""}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return ChartPanel.class;
            }
        };
        for (int r = 0; r < 25; r++) {
            ChartPanel[] row = new ChartPanel[4];
            for (int c = 0; c < row.length; c++) {
                final XYSeries series = new XYSeries("Data");
                int n = R.nextInt(N);
                for (int i = 0; i < n; i++) {
                    series.add(i, R.nextGaussian());
                }
                XYSeriesCollection dataset = new XYSeriesCollection(series);
                JFreeChart chart = ChartFactory.createXYLineChart(
                    "Random " + series.getItemCount(), "Domain", "Range", dataset);
                ChartPanel chartPanel = new ChartPanel(chart) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(W, H);
                    }
                };
                row[c] = chartPanel;
            }
            model.addRow(row);
        }
        JTable table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(4 * W, 2 * H);
            }
        };
        table.setDefaultRenderer(ChartPanel.class, new ChartRenderer());
        table.setRowHeight(W);
        f.add(new JScrollPane(table));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class ChartRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
            return (ChartPanel) value;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new ChartTable()::display);
    }
}