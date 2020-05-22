import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame window = new Main();
                window.setVisible(true);
            }
        });        
    }

    public Main() {
        JPanel east = new JPanel();
        east.setOpaque(true);
        east.setBackground(Color.WHITE);
        JPanel west = new JPanel();
        west.setOpaque(true);
        west.setBackground(Color.BLUE);

        JPanel content = new JPanel();
        content.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        content.add(east, gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        content.add(west, gbc);

        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

}