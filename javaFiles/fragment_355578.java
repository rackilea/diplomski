JMenuBar menubar1 = getJMenuBar();
for (int i = 0; i < menubar1.getMenuCount(); i++) {
    JMenu menu1 = menubar1.getMenu(i);
    System.out.println("Menu:" + menu1.getText());
    for (int j = 0; j < menu1.getMenuComponentCount(); j++) {
        java.awt.Component comp = menu1.getMenuComponent(j);
        if (comp instanceof JMenuItem) {
            JMenuItem menuItem1 = (JMenuItem) comp;
            System.out.println("MenuItem:" + menuItem1.getText());
        }
    }
}