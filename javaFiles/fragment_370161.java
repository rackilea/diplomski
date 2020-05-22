public class EmployeeDAO {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public EmployeeDAO() { 
        // TODO: Should initialize 'con', probably
    }

    public Statement getConnection() { 
        return st; // confused... getConnection should 'return con', no?
    }

    public void closeConnection() { 
        if (con != null) con.close();
    }

    public ArrayList<Employee> selectAllEmployees() {
        return new ArrayList<Employee>(); // TODO: replace with database stuff
    }

    // etc...