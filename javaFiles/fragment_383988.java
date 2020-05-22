import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ManualButtonGrid
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        int numRows = 5;
        int numCols = 5;

        //addButtonsA(panel, numRows, numCols);
        addButtonsB(panel, numRows, numCols);

        f.getContentPane().add(panel);
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static void addButtonsA(JPanel panel, int numRows, int numCols)
    {
        int size = 60;
        for (int r = 0; r < numRows; r++)
        {
            for (int c = 0; c < numCols; c++)
            {
                JButton b = new JButton(String.valueOf(r*numCols+c));
                b.setLocation(c*size, r*size);
                b.setSize(new Dimension(size, size));
                panel.add(b);
            }
        }
    }

    private static void addButtonsB(JPanel panel, int numRows, int numCols)
    {
        int size = 60;
        for (int i = 0; i < 25; i++)
        {
            JButton b = new JButton(String.valueOf(i));
            int r = i / numCols;
            int c = i % numCols;
            b.setLocation(c*size, r*size);
            b.setSize(new Dimension(size, size));
            panel.add(b);
        }
    }

}