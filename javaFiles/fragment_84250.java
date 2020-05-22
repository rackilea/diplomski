import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @see https://stackoverflow.com/a/36392696/230513
 * @see https://stackoverflow.com/a/36243395/230513
 */
public class CardPanel extends JPanel {

    private static final Random r = new Random();
    private static final JPanel cards = new JPanel(new CardLayout());
    private final String name;

    public CardPanel(String name) {
        super(new GridLayout());
        this.name = name;
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("One", r.nextInt(10) + 10);
        pieDataset.setValue("Two", r.nextInt(20) + 10);
        pieDataset.setValue("Three", r.nextInt(30) + 10);
        JFreeChart chart = ChartFactory.createPieChart3D(
            "3D Pie Chart", pieDataset, true, true, true);
        chart.setTitle(name);
        this.add(new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, (int)(500 * 0.62));
            }
        });
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }

    private static void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 1; i < 9; i++) {
            CardPanel p = new CardPanel("Chart " + String.valueOf(i));
            cards.add(p, p.toString());
        }
        JPanel control = new JPanel();
        control.add(new JButton(new AbstractAction("\u22b2Prev") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.previous(cards);
            }
        }));
        control.add(new JButton(new AbstractAction("Next\u22b3") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.next(cards);
            }
        }));
        f.add(cards, BorderLayout.CENTER);
        f.add(control, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}