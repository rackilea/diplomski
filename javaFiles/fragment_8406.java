import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class MenuSample {
    MenuSample() {
        JFrame frame = new JFrame("Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu menu = new JMenu("Megamenu");
        JPopupMenu popup = menu.getPopupMenu(); 
        popup.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        menuBar.add(menu);
        gbc.gridx = 0;
        gbc.gridy = 0;
        popup.add(createHeader("Header 1"), gbc);
        gbc.gridy++;
        popup.add(new JMenuItem("Item 1"), gbc);
        gbc.gridy++;
        popup.add(new JMenuItem("Item 2"), gbc);
        gbc.gridy++;
        popup.add(new JMenuItem("Item 3"), gbc);
        gbc.gridx++;
        gbc.gridy = 0;

        popup.add(createHeader("Header 2"), gbc);
        gbc.gridy++;
        popup.add(new JMenuItem("Item 3"), gbc);
        gbc.gridy++;
        popup.add(new JMenuItem("Item 4"), gbc);
        gbc.gridy++;
        popup.add(new JMenuItem("Item 5"), gbc);

        frame.pack();
        frame.setVisible(true);
    }

    private JComponent createHeader(String header) {
        JLabel label = new JLabel(header);
        label.setFont(label.getFont().deriveFont(Font.ITALIC));
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuSample();
            }
        });
    }
}