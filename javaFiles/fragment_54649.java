import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UnderlinePageStart {

    private JComponent ui = null;

    UnderlinePageStart() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        JPanel pageStart = new JPanel(new BorderLayout(2,2));
        ui.add(pageStart, BorderLayout.PAGE_START);
        pageStart.add(new JLabel("Page Start", SwingConstants.CENTER));
        // add a 'horizontal line'
        pageStart.add(new JSeparator(), BorderLayout.PAGE_END);

        ui.add(new JScrollPane(new JTextArea(5, 25)));
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                UnderlinePageStart o = new UnderlinePageStart();

                JFrame f = new JFrame("Underline Page Start");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}