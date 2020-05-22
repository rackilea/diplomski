import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class PrettyPrintControlChange {

    private JComponent ui = null;
    static final String rightwards = new String(Character.toChars(8594));

    PrettyPrintControlChange() {
        initUI();
    }

    public final void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        JTabbedPane tabbedPane = new JTabbedPane();
        ui.add(tabbedPane);

        final JTextArea textArea = new JTextArea(5, 45);
        ui.add(new JScrollPane(textArea), BorderLayout.PAGE_END);

        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                textArea.append(getPrettyCheckBoxString(cb) + "\n");
            }
        };

        for (int i = 1; i < 3; i++) { //tabs
            JPanel tabPanel = new JPanel(new GridLayout(0, 1, 4, 4));
            tabbedPane.addTab("Tab " + i, tabPanel);
            for (int j = 1; j < 4; j++) { // panels with titled border
                JPanel titledPanel = new JPanel(new GridLayout(1, 0, 4, 4));
                titledPanel.setBorder(new TitledBorder("Panel " + j));
                tabPanel.add(titledPanel);
                for (int k = 1; k < 7; k++) { // check boxes
                    JCheckBox checkBox = new JCheckBox("Check Box " + k);
                    checkBox.addActionListener(al);
                    titledPanel.add(checkBox);
                }
            }
        }
    }

    /**
     * Provides a string representing the state and containment hierarchy of a
     * check box. Uses the text of the check box, titled borders and tabbed pane
     * tab in which the check box appears to identify it.
     */
    private static String getPrettyCheckBoxString(JCheckBox cb) {
        StringBuilder sb = new StringBuilder("Check Box: ");
        ArrayList<Container> containerHeirarchy = new ArrayList<Container>();
        containerHeirarchy.add(cb);

        Container parent = cb.getParent();
        boolean foundTabbedPane = false;
        while (parent != null && !foundTabbedPane) {
            if (parent instanceof JTabbedPane) {
                foundTabbedPane = true;
            }
            containerHeirarchy.add(parent);
            parent = parent.getParent();
        }
        // traverse the collection in revers order.
        for (int i = containerHeirarchy.size() - 1; i >= 0; i--) {
            Container c = containerHeirarchy.get(i);
            if (c instanceof JTabbedPane) {
                JTabbedPane tp = (JTabbedPane) c;
                String title = tp.getTitleAt(tp.getSelectedIndex());
                sb.append(" tab: " + title);
            } else if (c instanceof JPanel) {
                JPanel panel = (JPanel) c;
                Border border = panel.getBorder();
                if (border instanceof TitledBorder) {
                    TitledBorder titledBorder = (TitledBorder) border;
                    String title = titledBorder.getTitle();
                    sb.append(" " + rightwards + " panel: " + title);
                }
            } else if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox)c;
                String title = checkBox.getText();
                sb.append(" " + rightwards + " check box: " + title);
            }
        }

        return sb.toString();
    }

    private static void prettyPrintCheckBox(JCheckBox cb) {
        System.out.println(getPrettyCheckBoxString(cb));
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
                PrettyPrintControlChange o = new PrettyPrintControlChange();

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