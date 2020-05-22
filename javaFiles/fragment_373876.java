import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DatabaseEntry {

    private String companyName;
    private int _id;
    private int employees;
    private StringProperty testString = new SimpleStringProperty();

    public DatabaseEntry(String companyName, int employees, int _id, String test) {
        this.companyName = companyName;
        this.employees = employees;
        this._id = _id;
        this.testString.setValue(test);
    }
}