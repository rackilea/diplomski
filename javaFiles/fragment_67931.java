public class YourJMenu extends JMenu {
   private ActionListener listener;
   public YourJMenu(String name, ActionListener listener){
      super(name);
      this.listener = listener;
   }
   @Override
   public JMenuItem add(JMenuItem item){
      item.addActionListener(listener);
      return super.add(item);
   }
}