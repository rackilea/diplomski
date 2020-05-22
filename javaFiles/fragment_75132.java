public class Event {

    private final StringProperty name;
    private final IntegerProperty x;
    private final IntegerProperty y;

    public Event(String name, int x, int y) {
        // set beans for properties here to make this instance accessible to listeners
        this.y = new SimpleIntegerProperty(this, "y", y);
        this.x = new SimpleIntegerProperty(this, "x", x);
        this.name = new SimpleStringProperty(this, "name", name);
    }

    public final String getName() {
        return this.name.get();
    }

    public final void setName(String value) {
        this.name.set(value);
    }

    public final StringProperty nameProperty() {
        return this.name;
    }

    public final int getX() {
        return this.x.get();
    }

    public final void setX(int value) {
        this.x.set(value);
    }

    public final IntegerProperty xProperty() {
        return this.x;
    }

    public final int getY() {
        return this.y.get();
    }

    public final void setY(int value) {
        this.y.set(value);
    }

    public final IntegerProperty yProperty() {
        return this.y;
    }

}