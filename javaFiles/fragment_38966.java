import java.awt.*;
import javax.swing.*;

public class JListExample
{
    private JList<String> list1;
    private JList<String> list2;
    private JList<String> list3;
    private JList<String> list4;
    private JList<String> list5;
    private CustomPanel panel1;
    private CustomPanel panel2;
    private CustomPanel panel3;
    private CustomPanel panel4;
    private CustomPanel panel5;
    private String[] data = {"one", "two", "three", "four"};
    private int width = 110;
    private int height = 300;

    private void displayGUI()
    {
        JFrame frame = new JFrame("JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 5, 2, 2));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.9;

        panel1 = new CustomPanel(width, height, Color.GRAY, "List 1");
        list1 = new JList<String>(data);
        panel1.add(list1, gbc);
        panel2 = new CustomPanel(width, height, 
                 Color.GREEN.brighter().brighter(), "List 2");
        list2 = new JList<String>(data);         
        panel2.add(list2, gbc);
        panel3 = new CustomPanel(width, height, 
                          Color.ORANGE.brighter(), "List 3");
        list3 = new JList<String>(data);                  
        panel3.add(list3, gbc);
        panel4 = new CustomPanel(width, height, 
                            Color.BLUE.brighter(), "List 4");
        list4 = new JList<String>(data);                    
        panel4.add(list4, gbc);
        panel5 = new CustomPanel(width, height, Color.RED, "List 5");
        list5 = new JList<String>(data);
        panel5.add(list5, gbc);

        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(panel3);
        contentPane.add(panel4);
        contentPane.add(panel5);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
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

class CustomPanel extends JPanel
{
    private final int GAP = 5;
    private int width;
    private int height;
    private Color backgroundColour;
    private JLabel titleLabel;

    public CustomPanel(int w, int h, Color c, String title)
    {
        width = w;
        height = h;
        backgroundColour = c;
        titleLabel = new JLabel(title, JLabel.CENTER);
        setBackground(backgroundColour);
        setBorder(
            BorderFactory.createEmptyBorder(
                                GAP, GAP, GAP, GAP));                   
        setLayout(new GridBagLayout()); 
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        add(titleLabel, gbc);
    }   

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(width, height));
    }
}