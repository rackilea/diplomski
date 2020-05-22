import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class FixedRowsTable {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[] columns = {"1","2","3","4","5","6","7"};
                Integer[][] data = new Integer[200000][columns.length];
                for (int xx=0; xx<data.length; xx++) {
                    for (int yy=0; yy<data[0].length; yy++) {
                        data[xx][yy] = new Integer((xx+1)*(yy+1));
                    }
                }
                final int rows = 11;

                JPanel gui = new JPanel(new BorderLayout(3,3));

                final JTable table = new JTable(
                    new DefaultTableModel(data, columns));

                final JScrollPane scrollPane = new JScrollPane(
                    table,
                    JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                Dimension d = table.getPreferredSize();
                scrollPane.setPreferredSize(
                    new Dimension(d.width,table.getRowHeight()*rows));

                JPanel navigation = new JPanel(
                    new FlowLayout(FlowLayout.CENTER));
                JButton next = new JButton(">");
                next.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        int height = table.getRowHeight()*(rows-1);
                        JScrollBar bar = scrollPane.getVerticalScrollBar();
                        bar.setValue( bar.getValue()+height );
                    }
                } );
                JButton previous = new JButton("<");
                previous.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        int height = table.getRowHeight()*(rows-1);
                        JScrollBar bar = scrollPane.getVerticalScrollBar();
                        bar.setValue( bar.getValue()-height );
                    }
                } );

                navigation.add(previous);
                navigation.add(next);

                gui.add(scrollPane, BorderLayout.CENTER);
                gui.add(navigation, BorderLayout.SOUTH);

                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}