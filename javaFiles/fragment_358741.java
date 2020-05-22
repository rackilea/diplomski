public class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {
     final static ImageIcon longIcon = new ImageIcon("long.gif");
     final static ImageIcon shortIcon = new ImageIcon("short.gif");

     // This is the only method defined by ListCellRenderer.
     // We just reconfigure the JLabel each time we're called.

     public Component getListCellRendererComponent(
       JList<?> list,           // the list
       Object value,            // value to display
       int index,               // cell index
       boolean isSelected,      // is the cell selected
       boolean cellHasFocus)    // does the cell have focus
     {
         String s = value.toString();
         setText(s);
         if (room.getMode() == RoomConstants.EMERGENCY_MODE) {
             setForeground(Color.RED);
         } 
         setEnabled(list.isEnabled());
         setFont(list.getFont());
         setOpaque(true);
         return this;
     }
 }

 myList.setCellRenderer(new MyCellRenderer());