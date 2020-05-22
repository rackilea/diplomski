from javax.swing import JFrame,JPanel,JScrollPane,JTable,JButton,JCheckBox,AbstractCellEditor
from javax.swing.table import AbstractTableModel,TableCellEditor,TableCellRenderer
from java.awt import GridLayout, Dimension 
from java.lang import String, Integer, Boolean,Class,Comparable
from java.util import ArrayList, List
from java.text import DecimalFormat

df = DecimalFormat("#0.00");
class TableSortDemo:


    def __init__(self):
        frame = JFrame("TableSortDemo")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        #Create and set up the content pane.       
        self.table = JTable(MyTableModel())
        self.table.setPreferredScrollableViewportSize(Dimension(500, 170))
        self.table.setFillsViewportHeight(True)
        self.table.setDefaultRenderer(Class.forName("java.lang.Object"), ValueRenderer());
        self.table.setDefaultEditor(Class.forName("java.lang.Object"), ValueEditor());
        self.table.setAutoCreateRowSorter(True)

        #Create the scroll pane and add the table to it.
        scrollPane = JScrollPane(self.table);

        #Add the scroll pane to this panel.
        newContentPane = JPanel()
        newContentPane.add(scrollPane);
        newContentPane.setOpaque(True)    #content panes must be opaque
        frame.setContentPane(newContentPane)
        #Display the window.
        frame.pack();
        frame.setVisible(True);

class Value(Comparable): #implements Comparable<Value> {

    def __init__(self,selected, value):
        self.selected = selected;
        self.value = value;

    def compareTo(self,v):
        return cmp(self.value-v.value, 0)

    def equals(self,v):
        return self.value == v.value

    def hashCode(self):
        return self.value.hashCode();        

class MyTableModel (AbstractTableModel):
    MAX = 8;
    names = ["Number", "Value"];
    values = ArrayList();
    for i in range(MAX):
        values.add(Value(False, (i + 1) * 1.1));

    def getRowCount(self):
        return self.MAX;

    def getColumnCount(self):
        return len(self.names)

    def getColumnName(self, col):
        return self.names[col];

    def getValueAt(self,row,col):
        if col == 0:
            return row + 1;
        elif col == 1:
            return self.values[row]
        else:
            return None

    def getColumnClass(self,col):
        if col == 0:
            return Integer
        elif col == 1:
            return Value
        else:
            return None;

    # Don't need to implement this method unless your table's editable.
    def isCellEditable(self,row, col):
        return col == 1;

    def setValueAt(self, aValue, row, col):
        if col == 1:
            self.values.get(row).selected = aValue;
            self.fireTableCellUpdated(row, col); 

class ValueRenderer (JCheckBox,TableCellRenderer):

    def getTableCellRendererComponent(self, table, value, isSelected, hasFocus, row, col):
        v = value;
        self.text = df.format(v.value)
        self.setSelected(v.selected);
        if isSelected:
            self.setForeground(table.getSelectionForeground());
            self.setBackground(table.getSelectionBackground());
        else:
            self.setForeground(table.getForeground());
            self.setBackground(table.getBackground());
        return self

class ValueEditor (TableCellEditor,AbstractCellEditor):

    def __init__(self):
        self.vr = ValueRenderer()

    def ValueEditor():
        self.vr.addItemListener(self);

    def getCellEditorValue(self):
        return self.vr.isSelected();

    def getTableCellEditorComponent(self,table,value,isSelected, row, col):
        v = value;
        self.vr.setSelected(v.selected);
        self.vr.setText(df.format(v.value));
        return self.vr;

    def itemStateChanged(self,e):
        self.fireEditingStopped(); 

if __name__ == '__main__':
    TableSortDemo()