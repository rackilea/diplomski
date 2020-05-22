public class CustomerDAO {

    private DatabaseManager databaseManager;

    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void addCustomer(Customer Customer) throws SQLException {
        databaseManager.getConnectionObject().prepareStatement("some sql... ");
    }

}