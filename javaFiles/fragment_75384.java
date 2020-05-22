import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



public class LayoutManagement02 extends JComponent {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

    final JLabel message = new JLabel("Default Message");
    final JLabel message2 = new JLabel("Default Message");

    public LayoutManagement02() {

        setLayout(new BorderLayout());

        JPanel centerPane = new JPanel(new GridBagLayout());
        JPanel menuPane = buildMenuPane();

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 0;

        message.setBackground(Color.pink);
        message.setOpaque(true);
        message.setPreferredSize(new Dimension(125, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(1, 1, 1, 1);
        centerPane.add(message, gbc);

        message2.setBackground(Color.pink);
        message2.setOpaque(true);
        message2.setPreferredSize(new Dimension(125, 50));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(1, 1, 1, 1);
        centerPane.add(message2, gbc);

        gbc = new GridBagConstraints();
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        menuPane.add(centerPane, gbc);

        add(menuPane);

    }

    public JPanel buildMenuPane() {

        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        b1 = new JButton("This");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(2, 2, 20, 2);

        b1.setPreferredSize(new Dimension(125, 25));
        b1.setBackground(Color.CYAN);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("This");
            }

        });

        pane.add(b1, gbc);

        b2 = new JButton("class");
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        b2.setPreferredSize(new Dimension(125, 25));
        b2.setBackground(Color.CYAN);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("class");
            }
        });

        pane.add(b2, gbc);

        b3 = new JButton("will");
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        b3.setPreferredSize(new Dimension(125, 25));
        b3.setBackground(Color.CYAN);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("will");
            }
        });
        pane.add(b3, gbc);

        b4 = new JButton("give");
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        b4.setPreferredSize(new Dimension(125, 25));
        b4.setBackground(Color.CYAN);
        b4.setOpaque(true);
        b4.setBorderPainted(false);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("give");
            }
        });
        pane.add(b4, gbc);

        b5 = new JButton("you");
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        b5.setPreferredSize(new Dimension(125, 25));
        b5.setBackground(Color.CYAN);
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("you");
            }
        });
        pane.add(b5, gbc);

        b6 = new JButton("practice");
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        b6.setPreferredSize(new Dimension(125, 25));
        b6.setBackground(Color.CYAN);
        b6.setOpaque(true);
        b6.setBorderPainted(false);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("practice");
            }
        });
        pane.add(b6, gbc);

        gbc.insets = new Insets(2, 2, 20, 2);

        b7 = new JButton("creating");
        gbc.gridx = 3;
        gbc.gridy = 0;
        b7.setPreferredSize(new Dimension(125, 25));
        b7.setBackground(Color.CYAN);
        b7.setOpaque(true);
        b7.setBorderPainted(false);
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message2.setText("creating");
            }
        });
        pane.add(b7, gbc);

        b8 = new JButton("and");
        gbc.gridx = 3;
        gbc.gridy = 1;
        b8.setPreferredSize(new Dimension(125, 25));
        b8.setBackground(Color.CYAN);
        b8.setOpaque(true);
        b8.setBorderPainted(false);
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message2.setText("and");
            }
        });
        pane.add(b8, gbc);

        b9 = new JButton("laying");
        gbc.gridx = 3;
        gbc.gridy = 2;
        b9.setPreferredSize(new Dimension(125, 25));
        b9.setBackground(Color.CYAN);
        b9.setOpaque(true);
        b9.setBorderPainted(false);
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message2.setText("laying");
            }
        });
        pane.add(b9, gbc);

        b10 = new JButton("out");
        gbc.gridx = 3;
        gbc.gridy = 3;
        b10.setPreferredSize(new Dimension(125, 25));
        b10.setBackground(Color.CYAN);
        b10.setOpaque(true);
        b10.setBorderPainted(false);
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message2.setText("out");
            }
        });
        pane.add(b10, gbc);

        b11 = new JButton("containers");
        gbc.gridx = 3;
        gbc.gridy = 4;
        b11.setPreferredSize(new Dimension(125, 25));
        b11.setBackground(Color.CYAN);
        b11.setOpaque(true);
        b11.setBorderPainted(false);
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message2.setText("containers");
            }
        });
        pane.add(b11, gbc);

        return pane;

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Management Lab");
        frame.add(new LayoutManagement02());

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}