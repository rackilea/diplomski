import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddItemOrColor extends JFrame
{
    private JPanel contentPane;
    private JButton modifyItemButton;
    private JButton modifyColorButton;
    private ActionListener action;
    private int count = 0;
    private Color[] color = { 
                                Color.RED, Color.BLUE, Color.GRAY,
                                Color.WHITE, Color.CYAN, Color.PINK,                                                                                                                                     
                                Color.DARK_GRAY, Color.ORANGE, Color.MAGENTA
                            };

    public AddItemOrColor()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        contentPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
        //contentPane.setMargin(new Insets(10, 10, 10, 10));
        contentPane.setBackground(Color.BLUE);

        modifyItemButton = new JButton("MODIFY CONTENT");
        modifyColorButton = new JButton("MODIFY COLOR");

        action = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JButton button = (JButton) ae.getSource();

                if (count == 9)
                    count = 0;

                if (button == modifyItemButton)
                {
                    contentPane.add(new JLabel("LABEL " + count));                  
                }
                else if (button == modifyColorButton)
                {
                    contentPane.setBackground(color[count]);
                }

                contentPane.revalidate();
                contentPane.repaint();
                count++;
            }
        };

        modifyItemButton.addActionListener(action);
        modifyColorButton.addActionListener(action);

        add(modifyColorButton, BorderLayout.PAGE_START);
        add(contentPane, BorderLayout.CENTER);
        add(modifyItemButton, BorderLayout.PAGE_END);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new AddItemOrColor();
            }
        });
    }
}