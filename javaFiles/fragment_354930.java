import java.awt.*;
import javax.swing.*;

public class LayoutTest
{
    private void displayGUI()
    {
        JFrame frame = new JFrame("Layout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.YELLOW);
        contentPane.setLayout(new BorderLayout(2, 2));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel headingLabel = new JLabel("Primary");
        topPanel.add(headingLabel);
        contentPane.add(topPanel, BorderLayout.PAGE_START);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.BLUE);
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JPanel imagePanel = new JPanel();   
        JLabel imageLabel = null;
        try
        {
            imageLabel = new JLabel(
                            new ImageIcon(
                                new java.net.URL(
                                    "http://pscode.org/"
                                    + "tame/screenshot/"
                                    + "landscape/slider1.gif")));
        }
        catch(Exception e)  
        {
            e.printStackTrace();
        }
        imagePanel.add(imageLabel);
        centerPanel.add(imagePanel, gbc);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setOpaque(true);
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(
                        BorderFactory.createEmptyBorder(
                                              5, 5, 5, 5));
        detailsPanel.setLayout(new GridLayout(0, 1, 5, 5));

        JLabel statusLabel = new JLabel("Chassis Status : ");
        JLabel usageLabel = new JLabel("Bandwidth Usage : ");
        JLabel fanLabel = new JLabel("Fan Status : ");

        detailsPanel.add(statusLabel);
        detailsPanel.add(usageLabel);
        detailsPanel.add(fanLabel);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.8;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        centerPanel.add(detailsPanel, gbc);

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
                new LayoutTest().displayGUI();
            }
        });
    }
}