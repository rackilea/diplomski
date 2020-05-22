public class DBView {

    private JTable jtable = new JTable(); 

    public void setDbTable(DefaultTableModel dbTable) {
        this.jtable.setModel(dbTable);
        //this.dbTable.repaint(); 
        //paintDBTable();
    }
    .
    .
    .
}