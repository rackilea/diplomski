import javafx.beans.property.*;

public class Person {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty gruppe = new SimpleStringProperty();
    private ObjectProperty<Arbeitgeber> arbeitgeber = new SimpleObjectProperty<>();

    public Person(int id, String name, String gruppe, Arbeitgeber arbeitgeber) {
        setId(id);
        setName(name);
        setGruppe(gruppe);
        setArbeitgeber(arbeitgeber);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGruppe() {
        return gruppe.get();
    }

    public StringProperty gruppeProperty() {
        return gruppe;
    }

    public void setGruppe(String gruppe) {
        this.gruppe.set(gruppe);
    }

    public Arbeitgeber getArbeitgeber() {
        return arbeitgeber.get();
    }

    public ObjectProperty<Arbeitgeber> arbeitgeberProperty() {
        return arbeitgeber;
    }

    public void setArbeitgeber(Arbeitgeber arbeitgeber) {
        this.arbeitgeber.set(arbeitgeber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                ", gruppe=" + gruppe +
                ", arbeitgeber=" + arbeitgeber +
                '}';
    }
}