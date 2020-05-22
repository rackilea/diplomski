import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AttributeRow {

    private final StringProperty name = new SimpleStringProperty();

    private final Map<String, BooleanProperty> activeByGroup = new HashMap<>();

    public AttributeRow(List<String> companyGroups) {
        for (String group : companyGroups) {
            activeByGroup.put(group, new SimpleBooleanProperty()) ;
        }
    }

    public final BooleanProperty activeProperty(String group) {
        // might need to deal with the case where
        // there is no entry in the map for group
        // (else calls to isActive(...) and setActive(...) with 
        // a non-existent group will give a null pointer exception):

        return activeByGroup.get(group) ;
    }

    public final boolean isActive(String group) {
        return activeProperty(group).get();
    }

    public final void setActive(String group, boolean active) {
        activeProperty(group).set(active);
    }

    public final StringProperty nameProperty() {
        return this.name;
    }


    public final String getName() {
        return this.nameProperty().get();
    }


    public final void setName(final String name) {
        this.nameProperty().set(name);
    }



}