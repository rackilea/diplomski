import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private final SimpleStringProperty age;
    private final SimpleStringProperty name;

    public Person(String age, String name) {
        this.age = new SimpleStringProperty(age);
        this.name = new SimpleStringProperty(name);
    }

    //add getters to properties with the appropriate naming convention  
    public final StringProperty ageProperty() {
        return age;
    }

    public final StringProperty nameProperty() {
        return name;
    }
}