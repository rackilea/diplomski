import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRowColor 
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("TableRowColor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new BorderLayout());

        final JTable table = createTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton changeColorButton = new JButton("Change color");
        changeColorButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                changeColor(table, 1);
            }
        });
        frame.getContentPane().add(changeColorButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JTable createTable()
    {
        String[] columnNames = { "First Name", "Last Name", "Sport", };
        Object[][] data = { { "Kathy", "Smith", "Snowboarding" },
            { "John", "Doe", "Rowing" }, { "Sue", "Black", "Knitting" },
            { "Jane", "White", "Speed reading" }, { "Joe", "Brown", "Pool" } };
        return new JTable(data, columnNames);
    }

    public static void changeColor(JTable table, final int coloredRow)
    {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column)
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
                if (row == coloredRow)
                {
                    setBackground(Color.RED);
                }
                else
                {
                    setBackground(null);
                }
                return this;
            }
        });
        table.repaint();

    }

}