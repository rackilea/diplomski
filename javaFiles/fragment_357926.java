class RowHeaderRenderer extends JLabel implements ListCellRenderer {

    RowHeaderRenderer(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    public Component getListCellRendererComponent(JList list, Object value,
                        int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

public class JTab_1E {                  // build & rtn a JTable w/ row headers

    public static JList rowHeader;                      // JList of row headers

    public static JTable getJTable() {                  // constructor

        String rowHdrs[] = { "CL", "v1", "v2", "v3", "v4", "TL", "AN" };
        String colHdrs[] = {  "0",  "1",  "2",  "3", "TL"             };
        int    colWids[] = {   16,   16,   16,   16,   30             };

        ListModel rowM = new AbstractListModel()  {     // 'rowM' for rowModel
            public int    getSize()               { return  rowHdrs.length; }
            public String getElementAt(int index) { return  rowHdrs[index]; }
        };

        DefaultTableModel dTM = new DefaultTableModel(colHdrs, rowM.getSize());

        JTable jTable = new JTable(dTM);                // JTable w/ colHdrs & 7 rows

        rowHeader = new JList(rowM);                    // setup JList of rowHdrs
        rowHeader.setFixedCellWidth(25);                // this works
        rowHeader.setFixedCellHeight(jTable.getRowHeight());
        rowHeader.setCellRenderer(new RowHeaderRenderer(jTable));

        for (int i = 0;  i < colHdrs.length;  i++) {    // set individual col wids
            TableColumn column = jTable.getColumnModel().getColumn(i);
            column.setMinWidth(      colWids[i]);
            column.setMaxWidth(      colWids[i]);
            column.setPreferredWidth(colWids[i]);
        }
        return  jTable;                 // rtn this new JTable with rowHdrs
    }
}