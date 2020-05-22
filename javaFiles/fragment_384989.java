public class Client extends DB {

private IntegerProperty id =         new SimpleIntegerProperty();
private StringProperty  lastName =   new SimpleStringProperty();
private StringProperty  firstName =  new SimpleStringProperty();

public final int getID() {return this.id.get(); }
void setID(int id) { this.id.set(id); }
public final IntegerProperty idProperty() { return this.id; }

public final String getLastName() { return this.lastName.get(); }
public final void setLastName(String ln) { this.lastName.set(ln); }
public final StringProperty lastNameProperty() { return this.lastName; }

public final String getFirstName() { return this.firstName.get(); }
public final void setFirstName(String fn) { this.firstName.set(fn); }
public final StringProperty firstNameProperty() { return this.firstName; }

Client(ResultSet jrs) {

    try {
        this.id.set(jrs.getInt(DB.CLI_FIELD_ID));
        this.lastName.set(jrs.getString(DB.CLI_FIELD_LAST));
        this.firstName.set(jrs.getString(DB.CLI_FIELD_FIRST));

    } catch (SQLException ex) {
        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        System.exit(1);
    }
}

static class ClientFactory implements Callback<ResultSet,Client> {

    @Override
    public Client call(ResultSet jrs) {
        return new Client(jrs);
    }
}