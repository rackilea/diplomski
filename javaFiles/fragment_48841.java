table.addMouseListener(new MouseAdapter() {         
        @Override
        public void mouseReleased(MouseEvent e) { 
            int selectedRow = table.rowAtPoint(e.getPoint());

            if (selectedRow >= 0 && selectedRow < table.getRowCount()) {
                if (!table.getSelectionModel().isSelectedIndex(selectedRow)) {
                    table.setRowSelectionInterval(selectedRow, selectedRow);
                }
            }

            if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {  
                this.show(e);
            }
        }

        private void show(MouseEvent e){
            int clickedRow=table.rowAtPoint(e.getPoint());
            int clickedCol=table.columnAtPoint(e.getPoint());
            Object data=table.getValueAt(row, i);

            DataClickedOnTable transportMeThere=new DataClickedOnTable(
              table, data, clickedRow, clickedColumn
            );
            contextMenu.setDataFromTable(transportMeThere);
            contextMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    });
   ///....
   ///...


// Just an example of structure transporting the data
// Add whatever data members are relevant
private /* inner */ class DataClickedOnTable {
   public TestTable source;
   public Object data;
   public int row;
   public int column;

   public DataClickedOnTable(
     TestTable source, Object data, int row, int col
   ) {
     this.source=source;
     this.data=data;
     this.col=col;
     this.row=row;
   }
}
public class ContextMenu extends JPopupMenu {
    JMenuItem item1;
    JMenuItem item2; 

    Object dataFromTable; // make it an Integer 

    public ContextMenu(IBurpExtenderCallbacks callbacks){
        this.item1 = new JMenuItem("item");
        this.item2 = new JMenuItem("item");

        this.item1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     
                // You already have the relevant data in the dataFromTable
                // Do want you need in this context
            }
        });
        this.item2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     
                // You already have the relevant data in the dataFromTable
                // Do want you need to do in this context
            }
        });

        add(item1);
        add(item2);
    }

    void setDataFromTable(DataClickedOnTable data) {
      this.dataFromTable=data;
      // filter possible actions based on the received data - some
      // actions are possible, some won't.
      // Example:
      this.item1.setEnabled(null!=data && (data.row % 2)==0);
      this.item2.setEnabled(
            null!=data 
         && ((data.row % 2)==1 || data.data instanceof Number)
      );

    }
}