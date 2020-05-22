package formatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty firstName = new SimpleStringProperty("");
    private final StringProperty surname = new SimpleStringProperty("");

    public Person(String firstName, String surname) {
        setFirstName(firstName);
        setSurname(surname);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String name) {
        this.firstName.set(name);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String name) {
        surname.set(name);
    }

    public StringProperty surnameProperty() {
        return surname;
    }
}