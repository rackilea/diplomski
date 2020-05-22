import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class NestedLayoutExample {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            @Override
            public void run() {
                final JFrame frame = new JFrame("Nested Layout Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(300, 400));

                final JPanel gui = new JPanel(new BorderLayout(5, 5));
                gui.setBorder(new TitledBorder("BorderLayout(5,5)"));

                JPanel dynamicLabels = new JPanel(new BorderLayout(4, 4));
                dynamicLabels.setBorder(new TitledBorder("BorderLayout(4,4)"));
                gui.add(dynamicLabels, BorderLayout.CENTER);

                final JPanel labels = new JPanel(new GridBagLayout());
                labels.setBorder(new TitledBorder("GridLayout(0,2,3,3)"));

                JButton addNew = new JButton("Add Another Label");
                dynamicLabels.add(addNew, BorderLayout.NORTH);
                addNew.addActionListener(new ActionListener() {

                    private int labelCount = 0;
                    private int gridx = 0;
                    private int gridy = 0;

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.weightx = 1;
                        gbc.weighty = 1;
                        gbc.gridx = gridx;
                        gbc.gridy = gridy;
                        labels.add(new JLabel("Label " + ++labelCount), gbc);
                        labels.revalidate();

                        gridy++;
                        if (gridy >= 4) {
                            gridy = 0;
                            gridx++;
                        }
                    }
                });

                dynamicLabels.add(new JScrollPane(labels), BorderLayout.CENTER);

                frame.setContentPane(gui);
                frame.pack();
                frame.setLocationRelativeTo(null);
                try {
                    // 1.6+
                    frame.setLocationByPlatform(true);
                    frame.setMinimumSize(frame.getSize());
                } catch (Throwable ignoreAndContinue) {
                }

                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}