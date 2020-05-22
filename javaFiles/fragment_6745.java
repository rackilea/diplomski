import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.MonthDay;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity

public class Person implements Externalizable {


    private static final long serialVersionUID = 1L;

    public Person() {

    }

    public Person(String name, MonthDay birthday) {
        setName(name);
        setBirthday(birthday);
    }

    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id ;
    }

    private final StringProperty name = new SimpleStringProperty(this, "name");

    // redundant, but here to indicate that annotations must be on the property accessors:
    @Column(name="name")
    public final String getName() {
        return name.get();
    }

    public final void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name ;
    }

    private final ObjectProperty<MonthDay> birthday = new SimpleObjectProperty<>();

    public final MonthDay getBirthday() {
        return birthday.get();
    }

    public final void setBirthday(MonthDay birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<MonthDay> birthdayProperty() {
        return birthday ;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getId());
        out.writeObject(getName());
        out.writeObject(getBirthday());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        setId(in.readInt());
        setName((String) in.readObject());
        setBirthday((MonthDay) in.readObject());
    }

}