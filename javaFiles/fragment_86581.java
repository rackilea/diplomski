int n = panel.getComponentCount();
if (n > 0) {
    Component[] components = panel.getComponents();
    for (int i = 0; i < components.length; i++) {
         if (components[i] instanceof JLabel) {
             JLabel label = (JLabel) components[i];
             label.setText("");
         } 
    }
}