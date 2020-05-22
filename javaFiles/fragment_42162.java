public void badFormPassingAroundConnectedResultSets(@Nonnull final ResultSet rs)
{
    try
    {
        while (rs.next()) { /* do something */ }
    }
    catch (final SQLException e)
    {
        throw new RuntimeException(e); // or log.error() but NEVER empty
    }
    finally
    {
        try { rs.getStatement().getConnection().close(); }
        catch (final SQLException e) { LOG.error(e.getMessage(), e); }
    }
}