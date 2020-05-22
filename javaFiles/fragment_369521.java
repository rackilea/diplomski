@RequestScoped
public class DAOObject implements Serializable {

private Logger LOG = Logger.getLogger(getClass().getName());

@Inject
private ConnectionWrapper wrapper;

private Connection connection;

@PostConstruct
public void init() {
    connection = wrapper.getConnection();
}

public void query(DTOObject dto) throws SQLException {
    String sql = "INSERT INTO DTO_TABLE VALUES (?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, dto.getName());
        statement.executeUpdate();
    }
}
}