import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BoxLayoutQuandary {

    private JComponent ui = null;

    BoxLayoutQuandary() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        NumberFormat numberFormat = new DecimalFormat("##.#");
        // Create the text fields and set them up.
        JFormattedTextField priemerKolesa = new JFormattedTextField(numberFormat);
        priemerKolesa.setColumns(8);
        JFormattedTextField hrubkaNavinu = new JFormattedTextField(numberFormat);
        hrubkaNavinu.setColumns(6);
        // Layout the text fields in a panel.
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.Y_AXIS));
        ui.add(fieldPane);
        JPanel priemerKolesaPanel = new JPanel();
        priemerKolesaPanel.add(priemerKolesa);
        fieldPane.add(priemerKolesaPanel);
        JPanel hrubkaNavinuPanel = new JPanel();
        hrubkaNavinuPanel.add(hrubkaNavinu);
        fieldPane.add(hrubkaNavinuPanel);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                BoxLayoutQuandary o = new BoxLayoutQuandary();

                JFrame f = new JFrame(o.getClass().getSimpleName());
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