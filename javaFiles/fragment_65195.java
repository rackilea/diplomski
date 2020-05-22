@SuppressWarnings("serial")
class MyLabPanelListCellRenderer extends DefaultListCellRenderer {
   @Override
   public Component getListCellRendererComponent(JList list, Object value,
         int index, boolean isSelected, boolean cellHasFocus) {
      if (value == null) {
         value = "";
      } else {
         value = ((LabPanel) value).getLabPanelDisplayName();
      }
      return super.getListCellRendererComponent(list, value, index, isSelected,
            cellHasFocus);
   }
}