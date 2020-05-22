import java.awt.BorderLayout;

import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class LiveJTableDemoFrame extends JFrame {
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_WIDTH = 400;
    //
    private JTable table;
    private String[] columnNames;
    private DefaultTableModel tableModel;

    public LiveJTableDemoFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //
        columnNames = new String[]{"ID", "A", "B", "C", "D"};
        //
        tableModel = new DefaultTableModel(columnNames, 0); 
        table = new JTable(tableModel);
        //
        final JScrollPane p = new JScrollPane();
        p.setViewportView(table);
        p.getVerticalScrollBar().getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                BoundedRangeModel scModel = p.getVerticalScrollBar().getModel();
                boolean valueIsAdjusting = scModel.getValueIsAdjusting();
                if(!valueIsAdjusting){
                    if(scModel.getValue() + scModel.getExtent() == scModel.getMaximum()){
                        retrieveData();
                    }
                }
            }
        });
        //
        retrieveData();
        //
        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
    }

    //Dummy method to simulate retrieving data from database
    private void retrieveData(){
        for (int i = 0; i < 10; i++){
            Object[] rowData = new Object[columnNames.length];
            //
            rowData[0] = tableModel.getDataVector().size();
            rowData[1] = "A";
            rowData[2] = "B";
            rowData[3] = "C";
            rowData[4] = "D";
            //
            tableModel.addRow(rowData); 
        }
        //tableModel.fireTableDataChanged();
    }

    public static void main(String[] args) {
        new LiveJTableDemoFrame().setVisible(true);
    }
}