import java.awt.*;
import javax.swing.*;

public class GridBagTest
{
    private String[] buttonText = { "C", ".", "/", "*", "7", "8", "9", "-", "4", "5",
            "6", "+", "1", "2", "3", "=", "0", "+/-" };
    private JButton[] button = new JButton[18];
    private int counter = 0;

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("GridBagLayout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout(2, 2));
        JTextField tfield = new JTextField();
        northPanel.add(tfield, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(2, 2, 2, 2);
        for (int i = 0; i < button.length; i++)
        {
            System.out.println("Button Text : " + buttonText[i]);
            button[i] = new JButton(buttonText[i]);
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                    gbc.gridx = j;
                    gbc.gridy = i;
                    centerPanel.add(button[counter++], gbc);
            }
        }
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(button[counter++], gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        centerPanel.add(button[counter++], gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        centerPanel.add(button[counter++], gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;  
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        centerPanel.add(button[counter++], gbc);
        int count = counter;
        System.out.println(button[--count].getText());
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        centerPanel.add(button[counter++], gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 4;
        centerPanel.add(button[counter++], gbc);

        contentPane.add(northPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);

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
                new GridBagTest().createAndDisplayGUI();
            }
        });
    }
}