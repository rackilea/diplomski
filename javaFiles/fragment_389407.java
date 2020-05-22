import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.gui.AdvancedTableFormat;
import ca.odell.glazedlists.gui.WritableTableFormat;
import ca.odell.glazedlists.swing.EventTableModel;

public class Tester {

private static class MyBoolean {
    private Boolean b = Boolean.FALSE;

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

}

private static class BooleanTableFormat implements AdvancedTableFormat<MyBoolean>, WritableTableFormat<MyBoolean> {

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        return "Bool";
    }

    @Override
    public Object getColumnValue(MyBoolean baseObject, int column) {
        return baseObject.getB();
    }

    @Override
    public Class getColumnClass(int column) {
        return Boolean.class;
    }

    @Override
    public Comparator getColumnComparator(int column) {
        throw new IllegalStateException("Not yet implemented.");
    }

    @Override
    public boolean isEditable(MyBoolean baseObject, int column) {
        return true;
    }

    @Override
    public MyBoolean setColumnValue(MyBoolean baseObject, Object editedValue, int column) {
        baseObject.setB((Boolean) editedValue);
        return baseObject;
    }
}

public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            EventList<MyBoolean> list = new BasicEventList<MyBoolean>();
            list.add(new MyBoolean());
            list.add(new MyBoolean());
            EventTableModel<MyBoolean> etm = new EventTableModel<MyBoolean>(list, new BooleanTableFormat());
            JTable table = new JTable(etm);
            JFrame f = new JFrame("Tester");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(300, 200);
            f.getContentPane().add(new JScrollPane(table));
            f.setVisible(true);
        }
    });

}
}