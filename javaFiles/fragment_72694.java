public class CustomTableCellRenderer extends DefaultTableCellRenderer 
{
//.....
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
   //create a component according to arguments recieved, and return
   //e.g. in simplest terms
   return new JTextField();
  }