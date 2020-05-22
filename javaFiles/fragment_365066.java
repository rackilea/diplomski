public class MyPresenter implements Presenter.Menu {

    @Override
    public JMenuItem getMenuPresenter() {
        MyMenuItem myMenuItem = Lookup.getDefault().lookup(MyMenuItem.class);
        return myMenuItem.getMenuItem();
    }
}