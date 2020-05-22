@Stateless
public class MyBean {

    @Resource(lookup = "java:/app/datasource")
    private DataSource dataSource;

    public void doStuff() {
        try (Connection connection = dataSource.getConnection()) {

            // Work with connection here

        } catch (SQLException e) {
            throw new SomeRuntimeException(e);
        }
    }
}