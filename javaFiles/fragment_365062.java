@ActionID(id = "com.company.MyPresenter", category = "Edit")
@ActionRegistration(displayName = "com.company.Bundle#CTL_MyPresenter")
@ActionReference(path = "Menu/Edit", position = 1)
public class MyPresenter implements Presenter.Menu {

    @Override
    public JMenuItem getMenuPresenter() {
        // return menu item from your ACL'd registry
    }
}