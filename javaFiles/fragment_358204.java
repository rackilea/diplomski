try
{
    return connection.getMetaData( ).supportsSchemasInTableDefinitions( );
}
catch ( SQLException e )
{
    try 
    {
        reconnect( );
        return connection.getMetaData( ).supportsSchemasInTableDefinitions( );
    }
    catch ( Exception e1 )
    {
        try
        {
            ResultSet rs = connection.getMetaData( ).getSchemas( );
            if( rs != null )
                return true;
            else
                return false;
        }
        catch (SQLException e2)
        {
            logger.log( Level.WARNING, e.getMessage( ), e1 );
            return false;
        }
    }
}