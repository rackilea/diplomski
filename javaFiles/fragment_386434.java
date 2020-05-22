public interface Customer { ... }

public interface CustomerDTO implements Iterable<Customer> { ... }

public class CustomerDTOSQLImpl {
    public CustomerDTOSQLImpl(ResultSet resultSet) { ... }

    @Override
    public Iterator<Customer> iterator() { ... }

    ...
}

public interface CustomerDAO {
    public CustomerDTO findById(int id);

    ...
}


public class CustomerDAOSQLImpl {
    @Inject
    private Connection connection;

    @Override
    public CustomerDTO findById(int id) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE ID = ?");
        statement.setInt(1, id);
        return new CustomerDTOSQLImpl(statement.executeQuery());
    }

    ...
}