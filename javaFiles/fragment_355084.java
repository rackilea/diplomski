@Override
public boolean isCellEditable(int row, int column) {
   if (column == 1) {
      return false;
   }  else {
      return true;
   }
}