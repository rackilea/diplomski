private void populateConnectionProp( ) throws SQLException
{
    if( jdbcConn!= null )
    {
        if( this.autoCommit != null )
            jdbcConn.setAutoCommit( this.autoCommit );
        else
        {
            if  (DBConfig.getInstance().qualifyPolicy(
                        jdbcConn.getMetaData().getDriverName(),
                        DBConfig.SET_COMMIT_TO_FALSE) ) {
                this.autoCommit = false;
                jdbcConn.setAutoCommit( false );
            }
        }
        if( this.isolationMode!= Constants.TRANSCATION_ISOLATION_DEFAULT)
            jdbcConn.setTransactionIsolation( this.isolationMode );
    }
}