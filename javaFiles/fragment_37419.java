import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;

public class TableRowResizeTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {   
                final JTable table = new JTable(3,3);
                final JTableHeader tHeader = table.getTableHeader();
                final JPanel tPanel = new JPanel(new GridBagLayout());
                tPanel.setBackground(Color.CYAN);
                ComponentListener cL = new ComponentAdapter() 
                {
                    @Override
                    public void componentResized(ComponentEvent e)
                    {
                        super.componentResized(e);
                        // re-size the header and row height to fill the whole tPanel
                        int panelHeight = tPanel.getHeight();
                        int numOfRows = table.getRowCount();
                        int desiredRowHeight = panelHeight / (numOfRows + 1);
                        int gap = panelHeight - desiredRowHeight * (numOfRows + 1);
                        tHeader.setPreferredSize(new Dimension(tHeader.getPreferredSize().width, 
                                desiredRowHeight+gap));
                        tHeader.revalidate();
                        tHeader.repaint();
                        if(desiredRowHeight <1)
                            desiredRowHeight = 1;
                        table.setRowHeight(desiredRowHeight);
                        table.revalidate();
                        table.repaint();
                        System.out.println("tPanel componentResized p.h="+tPanel.getHeight()
                            +"; desiredRowHeight="+desiredRowHeight+"; gap="+gap);
                    }                   
                };
                tPanel.addComponentListener(cL);
                GridBagConstraints c = new GridBagConstraints();
                c.fill = GridBagConstraints.VERTICAL;
                c.gridx = 0;
                c.gridy = 0;
                c.weighty = 1.0;
                tPanel.add(tHeader, c);
                c.gridy = 1;
                c.weighty = 0.0;
                tPanel.add(table,c);
                JPanel contentPane = new JPanel(new BorderLayout());
                contentPane.setBackground(Color.RED);
                contentPane.add(tPanel);
                JFrame f = new JFrame();
                f.setContentPane(contentPane);
                f.setSize(800, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.out.println("before f.setVisible p.h="+tPanel.getHeight());
                f.setVisible(true); 
                System.out.println("after f.setVisible p.h="+tPanel.getHeight());
            }
        });
    }
}