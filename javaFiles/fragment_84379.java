Component[] components = frame.getContentPane().getComponents();
for (Component component : components) {
   if (component instanceof JComponent) {
       ((JComponent) component).setBorder(null);
   }
}