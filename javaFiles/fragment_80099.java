import java.net.URL;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;

public class ToggleSplitMenuButton extends SplitMenuButton {

    private static final String STYLESHEET = "toggle-split-menu-button.css";

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    public ToggleSplitMenuButton() {
        super();
        initialize();
    }

    public ToggleSplitMenuButton(MenuItem ... items) {
        super(items);
        initialize();
    }

    private void initialize() {
        Class<?> clazz = getClass();
        URL resource = clazz.getResource(STYLESHEET);
        String stylesheet = resource.toExternalForm();
        ObservableList<String> stylesheets = getStylesheets();
        stylesheets.add(stylesheet);
    }

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/
    /**
     * Indicates whether this toggle split menu button is selected. This can be
     * manipulated programmatically.
     */
    private BooleanProperty selected;

    public final void setSelected(boolean value) {
        selectedProperty().set(value);
    }

    public final boolean isSelected() {
        return selected == null ? false : selected.get();
    }

    public final BooleanProperty selectedProperty() {
        if (selected == null) {
            selected = new BooleanPropertyBase() {

                @Override
                protected void invalidated() {
                    final boolean selected = get();
                    pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, selected);
                    notifyAccessibleAttributeChanged(AccessibleAttribute.SELECTED);
                }

                @Override
                public Object getBean() {
                    return ToggleSplitMenuButton.this;
                }

                @Override
                public String getName() {
                    return "selected";
                }
            };
        }
        return selected;
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public void fire() {
        if (!isDisabled()) {
            setSelected(!isSelected());
            fireEvent(new ActionEvent());
        }
    }

    /***************************************************************************
     *                                                                         *
     * Stylesheet Handling                                                     *
     *                                                                         *
     **************************************************************************/

    private static final PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("selected");
}