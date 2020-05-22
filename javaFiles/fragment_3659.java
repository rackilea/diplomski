public class MyTableModel extends AbstractTableModel {

     public boolean isCellEditable(int row, int col) {
        if (col== columnIndex) { //columnIndex: the column you want to make it editable
            return true;
        } else {
            return false;
        }
    }
}