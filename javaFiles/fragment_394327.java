package cardlayoutalignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class gridbaglayoutdemo
{

    JFrame Card = new JFrame();

    FlowLayout flow = new FlowLayout(FlowLayout.RIGHT, 2, 2);
    Border etch = BorderFactory.createEtchedBorder(Color.white, Color.gray);
    Border margin = new EmptyBorder(10, 10, 10, 10);

    public static GridBagLayout grid = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    final static boolean shouldFill = true;

    JPanel container = new JPanel();
    JPanel divider = new JPanel();
    JPanel bodypanel = new JPanel();
    final JPanel buttonpanel = new JPanel();
    JPanel panel_1 = new JPanel();
    JPanel panel_4 = new JPanel();
    CardLayout cl = new CardLayout();

    public gridbaglayoutdemo()
    {
        Card.setVisible(true);
        Card.setSize(605, 333);
        Card.setTitle("Tank Delivery");
        // Card.setResizable(false);

        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - Card.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - Card.getHeight()) / 2);

        Card.setLocation(x, y);
        Card.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bodypanel.setLayout(new BorderLayout());

        divider.setLayout(new BorderLayout());

        container.setLayout(cl);
        cl.show(container, "1");

        // JOptionPane.showMessageDialog(null,
        // "Memory is full. Finish 1 transaction in order to use Memory again");

        panel_1.setLayout(grid);

        JLabel label_1 = new JLabel("Enter Tank:");
        label_1.setFont(new Font("Arial", Font.PLAIN, 18));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 0);
        panel_1.add(label_1, c);

        JComboBox box_1 = new JComboBox();
        box_1.setPreferredSize(new Dimension(200, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 20;
        c.insets = new Insets(10, 10, 0, 0);
        panel_1.add(box_1, c);

        JLabel label = new JLabel("");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 30;
        c.insets = new Insets(10, 0, 0, 0);
        panel_1.add(label, c);

        panel_4.setLayout(grid);

        JLabel label_2 = new JLabel("Enter Date:");
        label_2.setFont(new Font("Arial", Font.PLAIN, 18));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 0);
        panel_4.add(label_2, c);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        df.setLenient(false);

        JFormattedTextField text_2 = new JFormattedTextField(df);
        text_2.setValue(new Date());
        text_2.setPreferredSize(new Dimension(200, 30));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(10, 10, 0, 0);
        panel_4.add(text_2, c);

        JLabel label_3 = new JLabel("Enter Time:");
        label_3.setFont(new Font("Arial", Font.PLAIN, 18));
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(10, 10, 0, 10);
        panel_4.add(label_3, c);


        String time3 = new java.text.SimpleDateFormat("HH").format(new java.util.Date());
        JFormattedTextField text_33 = new JFormattedTextField();
        text_33.setValue(time3);

        JLabel label_4 = new JLabel(":");
        label_4.setFont(new Font("Arial", Font.PLAIN, 18));

        String time2 = new java.text.SimpleDateFormat("mm").format(new java.util.Date());
        JFormattedTextField text_4 = new JFormattedTextField();
        text_4.setValue(time2);

        JButton btnup = new JButton("UP");
        btnup.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton btndown = new JButton("DOWN");
        btndown.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel upDownPanel = new JPanel(new BorderLayout());
        upDownPanel.add(btnup, BorderLayout.PAGE_START);
        upDownPanel.add(btndown, BorderLayout.PAGE_END);

        JPanel timeInputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        timeInputPanel.add(text_33);
        timeInputPanel.add(label_4);
        timeInputPanel.add(text_4);
        timeInputPanel.add(upDownPanel);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 15;
        c.insets = new Insets(0, 10, 0, 0);
        panel_4.add(timeInputPanel, c);

        JLabel label14 = new JLabel("");
        label14.setFont(new Font("Arial", Font.PLAIN, 18));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 30;
        c.insets = new Insets(10, 0, 0, 0);
        panel_4.add(label14, c);

        buttonpanel.setLayout(new FlowLayout(SwingConstants.RIGHT));
        buttonpanel.setBorder(new EmptyBorder(0, 10, 0, 0));

        JButton btnBack = new JButton("< Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                cl.previous(container);
                buttonpanel.repaint();
            }
        });
        btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
        btnBack.setFocusable(false);
        btnBack.setFocusTraversalKeysEnabled(false);
        btnBack.setFocusPainted(false);
        btnBack.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        btnBack.setPreferredSize(new Dimension(110, 40));
        btnBack.setBackground(new Color(224, 223, 227));
        buttonpanel.add(btnBack);

        JButton btnNext = new JButton("Next >");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                cl.next(container);
                buttonpanel.repaint();
            }
        });
        btnNext.setFont(new Font("Arial", Font.PLAIN, 20));
        btnNext.setFocusable(false);
        btnNext.setFocusTraversalKeysEnabled(false);
        btnNext.setFocusPainted(false);
        btnNext.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        btnNext.setPreferredSize(new Dimension(110, 40));
        btnNext.setBackground(new Color(224, 223, 227));
        buttonpanel.add(btnNext);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        btnCancel.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCancel.setFocusable(false);
        btnCancel.setFocusTraversalKeysEnabled(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        btnCancel.setPreferredSize(new Dimension(110, 40));
        btnCancel.setBackground(new Color(224, 223, 227));
        buttonpanel.add(btnCancel);

        divider.add(container, BorderLayout.NORTH);
        container.add(panel_1, "1");
        // container.add(p2.panel_2, "2");
        // container.add(p3.panel_3, "3");
        container.add(panel_4, "4");
        divider.add(buttonpanel, BorderLayout.SOUTH);

        JPanel numberpanel = new JPanel();
        numberpanel.setPreferredSize(new Dimension(221, 0));
        numberpanel.setBorder(new EmptyBorder(10, 0, 0, 10));
        numberpanel.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.gray));
        numberpanel.setLayout(flow);

        JButton button_7 = new JButton("7");
        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_7.setFont(new Font("Arial", Font.PLAIN, 30));
        button_7.setFocusable(false);
        button_7.setFocusTraversalKeysEnabled(false);
        button_7.setFocusPainted(false);
        button_7.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_7.setPreferredSize(new Dimension(70, 70));
        button_7.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_7);

        JButton button_8 = new JButton("8");
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_8.setFont(new Font("Arial", Font.PLAIN, 30));
        button_8.setFocusable(false);
        button_8.setFocusTraversalKeysEnabled(false);
        button_8.setFocusPainted(false);
        button_8.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_8.setPreferredSize(new Dimension(70, 70));
        button_8.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_8);

        JButton button_9 = new JButton("9");
        button_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_9.setFont(new Font("Arial", Font.PLAIN, 30));
        button_9.setFocusable(false);
        button_9.setFocusTraversalKeysEnabled(false);
        button_9.setFocusPainted(false);
        button_9.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_9.setPreferredSize(new Dimension(70, 70));
        button_9.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_9);

        JButton button_4 = new JButton("4");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_4.setFont(new Font("Arial", Font.PLAIN, 30));
        button_4.setFocusable(false);
        button_4.setFocusTraversalKeysEnabled(false);
        button_4.setFocusPainted(false);
        button_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_4.setPreferredSize(new Dimension(70, 70));
        button_4.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_4);

        JButton button_5 = new JButton("5");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_5.setFont(new Font("Arial", Font.PLAIN, 30));
        button_5.setFocusable(false);
        button_5.setFocusTraversalKeysEnabled(false);
        button_5.setFocusPainted(false);
        button_5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_5.setPreferredSize(new Dimension(70, 70));
        button_5.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_5);

        JButton button_6 = new JButton("6");
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_6.setFont(new Font("Arial", Font.PLAIN, 30));
        button_6.setFocusable(false);
        button_6.setFocusTraversalKeysEnabled(false);
        button_6.setFocusPainted(false);
        button_6.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_6.setPreferredSize(new Dimension(70, 70));
        button_6.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_6);

        JButton button_1 = new JButton("1");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_1.setFont(new Font("Arial", Font.PLAIN, 30));
        button_1.setFocusable(false);
        button_1.setFocusTraversalKeysEnabled(false);
        button_1.setFocusPainted(false);
        button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_1.setPreferredSize(new Dimension(70, 70));
        button_1.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_1);

        JButton button_2 = new JButton("2");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_2.setFont(new Font("Arial", Font.PLAIN, 30));
        button_2.setFocusable(false);
        button_2.setFocusTraversalKeysEnabled(false);
        button_2.setFocusPainted(false);
        button_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_2.setPreferredSize(new Dimension(70, 70));
        button_2.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_2);

        JButton button_3 = new JButton("3");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_3.setFont(new Font("Arial", Font.PLAIN, 30));
        button_3.setFocusable(false);
        button_3.setFocusTraversalKeysEnabled(false);
        button_3.setFocusPainted(false);
        button_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_3.setPreferredSize(new Dimension(70, 70));
        button_3.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_3);

        JButton button_0 = new JButton("0");
        button_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_0.setFont(new Font("Arial", Font.PLAIN, 30));
        button_0.setFocusable(false);
        button_0.setFocusTraversalKeysEnabled(false);
        button_0.setFocusPainted(false);
        button_0.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_0.setPreferredSize(new Dimension(70, 70));
        button_0.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_0);

        JButton button_left = new JButton("");
        button_left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_left.setIcon(new ImageIcon("more_buttons\\left.png"));
        button_left.setFont(new Font("Arial", Font.PLAIN, 30));
        button_left.setFocusable(false);
        button_left.setFocusTraversalKeysEnabled(false);
        button_left.setFocusPainted(false);
        button_left.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_left.setPreferredSize(new Dimension(70, 70));
        button_left.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_left);

        JButton button_right = new JButton("");
        button_right.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button_right.setIcon(new ImageIcon("more_buttons\\right.png"));
        button_right.setFont(new Font("Arial", Font.PLAIN, 30));
        button_right.setFocusable(false);
        button_right.setFocusTraversalKeysEnabled(false);
        button_right.setFocusPainted(false);
        button_right.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
        button_right.setPreferredSize(new Dimension(70, 70));
        button_right.setBackground(new Color(224, 223, 227));
        numberpanel.add(button_right);

        Card.add(bodypanel);
        bodypanel.add(divider, BorderLayout.WEST);
        bodypanel.add(numberpanel, BorderLayout.EAST);

    }

    public static void main(String[] args)
    {
        // Use the event dispatch thread for Swing components
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                new gridbaglayoutdemo();
            }
        });

    }
}