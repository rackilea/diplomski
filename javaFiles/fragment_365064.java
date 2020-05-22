@ServiceProvider(service = ControllableMenuItem.class)
public class MyMenuItem implements ControllableMenuItem {

    private JMenuItem menuItem;

    @Override
    public void setEnabled(boolean enabled) {
        getMenuItem().setEnabled(enabled);
    }

    @Override
    public JMenuItem getMenuItem() {
        if (menuItem == null) {
            menuItem = new JMenuItem(new MyAction());
        }
        return menuItem;
    }
}