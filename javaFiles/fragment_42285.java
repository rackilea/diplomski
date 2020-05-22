public class DataSourceWrapper {
    private DataSource original;
    public DataSourceWrapper(DataSource original) {
        this.original = original;
    }

    public Connection getConnection() {
        return original.getConnection(currentUser(), currentPassword());
    }

    ...

    public DataSource getOriginal() {
        return original;
    }
}