import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ComboBoxExample {

    private void createUI() {

        JFrame frame = new JFrame();

        Object[] columNames = {"Combo-1", "Combo-2"};
        Object[][] data = {{"", ""}, {"", ""}, {"", ""}, {"", ""}};

        JTable table = new JTable(data, columNames);

        table.getColumnModel().getColumn(0).setCellEditor(new CustomComboBoxEditor());
        table.getColumnModel().getColumn(1).setCellEditor(new CustomComboBoxEditor());

        frame.add(new JScrollPane(table));
        frame.setTitle("Column -2 based on Column - 1 ComboBox Selection.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new ComboBoxExample().createUI();
            }
        };

        EventQueue.invokeLater(r);
    }

}

class CustomComboBoxEditor extends DefaultCellEditor {

    // Declare a model that is used for adding the elements to the `ComboBox`
    private DefaultComboBoxModel model;

    private List<String> obtainedList;

    public CustomComboBoxEditor() {
        super(new JComboBox());
        this.model = (DefaultComboBoxModel)((JComboBox)getComponent()).getModel();
        obtainedList = new ArrayList<String>();

        obtainedList.add("One");
        obtainedList.add("Two");
        obtainedList.add("Three");
        obtainedList.add("Four");
        obtainedList.add("Five");
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {


       if(column == 0) {
           model.removeAllElements();
           for(int i = 0; i < obtainedList.size(); i++) {
               model.addElement(obtainedList.get(i));
            } 
        } else {

             model.removeAllElements();
             String selectedItem = (String) table.getValueAt(row, 0);
             for(int i = 0; i < obtainedList.size(); i++) {
                    if(!selectedItem.equals(obtainedList.get(i)))
                    model.addElement(obtainedList.get(i));
             } 
         } // Close else

        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
     }
    }