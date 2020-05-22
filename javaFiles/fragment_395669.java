public class MyRenderer extends DefaultTableCellRenderer{
   public Component getTableCellRendererComponent(JTable table, Object value, boolean   isSelected, boolean hasFocus, int row, int column) 
   {
       Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 

           if(value)
               c.setBackground(/*Color for booked days*/ );
           else
               c.setBackground(table.getBackground());  

       return c;
   } 
}