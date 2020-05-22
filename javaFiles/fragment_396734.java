import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestBarChart extends JPanel {
    private static final int[] INIT_DATA = { 1, 2, 4, 5, 6, 9 };
    protected static final int MIN_DATA_lENGTH = 5;
    protected static final int MAX_DATA_LENGTH = 9;
    private static final int MAX_VALUE = 9;
    private static final int PREF_W = 300;
    private static final int PREF_H = 240;
    private BarChart2 barChart2 = new BarChart2(INIT_DATA, MAX_VALUE, PREF_W, PREF_H);

    public TestBarChart() {
        barChart2.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JPanel chartsPanel = new JPanel(new GridLayout(1, 0));
        chartsPanel.setLayout(new GridLayout(1, 0));
        chartsPanel.add(barChart2);

        JButton resetDataBtn = new JButton(new AbstractAction("Reset Data") {

            @Override
            public void actionPerformed(ActionEvent e) {
                int dataLength = (int) ((MAX_DATA_LENGTH - MIN_DATA_lENGTH) * Math.random()) + MIN_DATA_lENGTH;
                int[] data = new int[dataLength];
                for (int i = 0; i < data.length; i++) {
                    data[i] = (int) (MAX_VALUE * Math.random()) + 1;
                }
                barChart2.setData(data, MAX_VALUE);
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(resetDataBtn);        

        setLayout(new BorderLayout());
        add(chartsPanel);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        TestBarChart mainPanel = new TestBarChart();

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}