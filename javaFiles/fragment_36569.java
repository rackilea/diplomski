class MyCellRenderer extends JLabel implements ListCellRenderer {
         ImageIcon longIcon = new ImageIcon("long.gif");
         ImageIcon shortIcon = new ImageIcon("short.gif");

        // This is the only method defined by ListCellRenderer.
        // We just reconfigure the JLabel each time we're called.

        public Component getListCellRendererComponent(
                JList list,              // the list
                Object value,            // value to display
                int index,               // cell index
                boolean isSelected,      // is the cell selected
                boolean cellHasFocus)    // does the cell have focus
        {
            Action action = (Action)value;
            setText((String)action.getValue(Action.NAME));
            setIcon((Icon)action.getValue(Action.SMALL_ICON));
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);
            return this;
        }
    }