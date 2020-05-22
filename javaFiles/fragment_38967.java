import java.awt.*;
import javax.swing.*;

public class JListExample
{
    private final int GAP = 5;
    private JList<String> list1;
    private JList<String> list2;
    private JList<String> list3;
    private JList<String> list4;
    private JList<String> list5;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private String[] data = {"one", "two", "three", "four"};
    private int width = 110;
    private int height = 300;
    private GridBagConstraints gbc = new GridBagConstraints();

    private void displayGUI()
    {
        JFrame frame = new JFrame("JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 5, 2, 2));      

        panel1 = getPanel(Color.GRAY, "List 1");
        list1 = new JList<String>(data);

        panel2 = getPanel(Color.GREEN.brighter().brighter(), "List 2");
        list2 = new JList<String>(data);         

        panel3 = getPanel(Color.ORANGE.brighter(), "List 3");
        list3 = new JList<String>(data);                  

        panel4 = getPanel(Color.BLUE.brighter(), "List 4");
        list4 = new JList<String>(data);                    

        panel5 = getPanel(Color.RED, "List 5");
        list5 = new JList<String>(data);        

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.9;

        panel1.add(list1, gbc);
        panel2.add(list2, gbc);
        panel3.add(list3, gbc);
        panel4.add(list4, gbc);
        panel5.add(list5, gbc);

        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(panel3);
        contentPane.add(panel4);
        contentPane.add(panel5);

        frame.setContentPane(contentPane);
        frame.setSize(610, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel getPanel(Color c, String title)
    {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBorder(
            BorderFactory.createEmptyBorder(
                                GAP, GAP, GAP, GAP));       
        panel.setBackground(c);
        panel.setLayout(new GridBagLayout());   
        JLabel label = new JLabel(title, JLabel.CENTER);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;

        panel.add(label, gbc);

        return panel;
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new JListExample().displayGUI();
            }
        });
    }
}