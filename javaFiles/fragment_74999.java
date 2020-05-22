import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean
@RequestScoped
public class CrumbBean {

    private MenuModel model;

    public CrumbBean() {
        model = new DefaultMenuModel();
        MenuItem item1 = new MenuItem();
        item1.setValue("First");
        item1.setUrl("#");
        model.addMenuItem(item1);

        MenuItem item2 = new MenuItem();
        item2.setValue("Second");
        item2.setUrl("#");
        model.addMenuItem(item2);
    }

    public MenuModel getModel() {
        return model;
    }

}