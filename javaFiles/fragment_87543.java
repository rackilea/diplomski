import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Tester extends JPanel{
    public Tester(){
        super(new MigLayout("", "[grow]15[grow]", "[grow]15[grow]"));

        JButton btnDailyLog = new JButton("Daily Log");
        JButton btnEmpReports = new JButton("Employee Reports");
        JButton btnJobReports = new JButton("Job Reports");

        add(btnDailyLog,"spany 2,grow");
        add(btnEmpReports, "grow,wrap");
        add(btnJobReports, "grow");
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(440, 163);
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Tester");

        Tester tester = new Tester();
        frame.add(tester);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}