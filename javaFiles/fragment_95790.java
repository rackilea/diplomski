public class EmptyListExceptionWrapper implements Wrapper {
    @Override
    public <T> T unwrap(Class<T> paramClass) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> paramClass) throws SQLException {
        return false;
    }
}