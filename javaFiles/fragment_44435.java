public class MyCellRenderer extends DefaultListCellRenderer {
    @Override
     public Component getListCellRendererComponent(JList list, Object item,
         int index, boolean isSelected, boolean cellHasFocus)
     {
         super.getListCellRendererComponent(list, item,
             index, isSelected, cellHasFocus);
         if (item != null && (item instanceof FooBar))
         {
             FooBar fooBar = (FooBar)item;
             String foo = fooBar.getFoo();
             setText(foo);
         }
         return this;
    }
}