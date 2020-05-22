public class Topping {

    private final String name ;

    private final BooleanProperty selected = new SimpleBooleanProperty();

    public Topping(String name) {
        this.name = name ;
    }

    public BooleanProperty selectedProperty() {
        return selected ;
    }

    public final boolean isSelected() {
        return selectedProperty().get();
    }

    public final void setSelected(boolean selected) {
        selectedProperty().set(selected);
    }

    public String getName() {
        return name ;
    }

    @Override
    public String toString() {
        return getName();
    }
}