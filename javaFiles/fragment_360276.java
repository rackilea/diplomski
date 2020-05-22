import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class TextFile {

    private final StringProperty name = new SimpleStringProperty(this, "name");
    public final void setName(String name) { this.name.set(name); }
    public final String getName() { return name.get(); }
    public final StringProperty nameProperty() { return name; }

    private final LongProperty size = new SimpleLongProperty(this, "size");
    public final void setSize(long size) { this.size.set(size); }
    public final long getSize() { return size.get(); }
    public final LongProperty sizeProperty() { return size; }

    public TextFile() {}

    public TextFile(String name, long size) {
        setName(name);
        setSize(size);
    }

}