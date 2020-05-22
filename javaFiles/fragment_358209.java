private java.util.List getCallableParamMetaData( )
{
    java.util.List paramMetaDataList = new ArrayList( );
    try
    {
        DatabaseMetaData metaData = conn.getMetaData( );
        String cataLog = conn.getCatalog( );
        String procedureNamePattern = getNamePattern( this.paramUtil.getProcedure( ) );
        String schemaPattern = null;
        if ( this.paramUtil.getSchema( ) != null )
        {
            schemaPattern = getNamePattern( this.paramUtil.getSchema( ) );
        }

        // handles schema.package.storedprocedure for databases such as
        // Oracle
        if ( !metaData.supportsCatalogsInProcedureCalls( ) )
        {
            if (this.paramUtil.getPackage( ) != null)
            {
                cataLog = getNamePattern( this.paramUtil.getPackage( ) );
            }
        }

        java.sql.ResultSet rs = null;
        rs = metaData.getProcedureColumns( cataLog,
                schemaPattern,
                procedureNamePattern,
                null );
        while ( rs.next( ) )
        {
            ParameterDefn p = new ParameterDefn( );
            p.setParamName( rs.getString( "COLUMN_NAME" ) );
            p.setParamInOutType( rs.getInt( "COLUMN_TYPE" ) );
            p.setParamType( rs.getInt( "DATA_TYPE" ) );
            p.setParamTypeName( rs.getString( "TYPE_NAME" ) );
            p.setPrecision( rs.getInt( "PRECISION" ) );
            p.setScale( rs.getInt( "SCALE" ) );
            p.setIsNullable( rs.getInt( "NULLABLE" ) );
            if ( p.getParamType( ) == Types.OTHER )
                correctParamType( p );
            paramMetaDataList.add( p );
        }
        rs.close( );
    }
    catch ( SQLException e )
    {
        logger.log( Level.SEVERE, "Fail to get SP paramters", e );
    }
    catch( JDBCException ex)
    {
        logger.log( Level.SEVERE, "Fail to get SP paramters", ex );
    }
    catch( NullPointerException ex1)
    {
        logger.log( Level.SEVERE, "Fail to get SP paramters", ex1 );
    }
    return paramMetaDataList;
}