import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class GridBag extends JFrame
{

    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                new GridBag().setVisible(true);
            }
        });
    }

    public GridBag()
    {

        UIManager.put("swing.boldMetal", Boolean.FALSE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Grid Bag");
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel container = new JPanel(new GridBagLayout());
        container.setBorder(new LineBorder(Color.RED, 2));
        add(container);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.LAST_LINE_START;

        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        bottom.setBorder(new LineBorder(Color.GREEN, 2));
        container.add(bottom, c);

        JTextPane textPane = new JTextPane();
        textPane.setText("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et ");
        textPane.setBorder(new LineBorder(Color.BLACK, 2));
        bottom.add(new JScrollPane(textPane));

        JTextPane textPane2 = new JTextPane();
        textPane2.setText("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et ");
        textPane2.setBorder(new LineBorder(Color.BLUE, 2));
        bottom.add(new JScrollPane(textPane2));
    }
}