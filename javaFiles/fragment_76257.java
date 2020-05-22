import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.Actions;
import org.openide.awt.DynamicMenuContent;
import org.openide.util.actions.Presenter;

/* Register your dynamic action using annotations (perferred over layer.xml entries)
@ActionID(id = "ExampleDynamicMenu", category = "Edit")
@ActionRegistration(lazy = false, displayName = "ExampleDynamicMenu")
@ActionReferences({
    @ActionReference(path = "Loaders/folder/any/Actions", position = 666),
    @ActionReference(path = "Loaders/content/unknown/Actions", position = 666),
    @ActionReference(path = "Loaders/text/xml/Actions", position = 666),
    @ActionReference(path = "Projects/Actions", position = 666),
    @ActionReference(path = "Editors/TabActions", position = 666)
})
*/
public class ExampleDynamicMenu extends AbstractAction implements DynamicMenuContent, Presenter.Popup {

    @Override
    public JMenuItem getPopupPresenter() {
        JMenu menu = new JMenu(this);
        JComponent[] menuItems = createMenu();
        for (JComponent item : menuItems) {
            menu.add(item);
        }
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // does nothing, this is a popup menu
    }

    @Override
    public JComponent[] getMenuPresenters() {
        return createMenu();
    }

    @Override
    public JComponent[] synchMenuPresenters(JComponent[] items) {
        return createMenu();
    }

    private JComponent[] createMenu() {
        List<JComponent> items = new ArrayList<>(20);

        //TODO: Load the list of actions stored in the preferences, and for each action add a menu-item to the dynamic menu.
        // Note: You preferences can simply store the Action's category and id; then you can always get the action instances using
        //    Action action = Actions.forID(category_string, id_string);
        List<Action> actionsList = YOUR_PREFERENCES_GETTER.getActions(); //You have to figure out how to store and retrieve user's preferred actions list yourself :)
        for (Action action : actionsList) {
            if (action == null) { //Assume null means add a separator
                if (items.size() > 0 && !(items.get(items.size() - 1) instanceof JSeparator)) { //Only add separators after actions.
                    items.add(new JPopupMenu.Separator());
                }
            } else { //Convert action to menu item, and build your dynamic menu
                items.add(toMenuItem(action));
            }
        }
        return items.toArray(new JComponent[items.size()]);
    }

    /**
     * Creates a menu item from an action.
     *
     * @param action an action
     * @return JMenuItem
     */
    private static JMenuItem toMenuItem(Action action) {
        JMenuItem item;
        if (action instanceof Presenter.Menu) {
            item = ((Presenter.Menu) action).getMenuPresenter();
        } else if (action instanceof Presenter.Popup) {
            item = ((Presenter.Popup) action).getPopupPresenter();
        } else {
            item = new JMenuItem();
            Actions.connect(item, action, false);
        }
        return item;
    }
}