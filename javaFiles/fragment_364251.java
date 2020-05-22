public String getJavaType( String schema, String object, String column )
    throws Exception {
    String fullName = schema + '.' + object + '.' + column;
    DatabaseMetaData metaData = getConnection().getMetaData();
    ResultSet columnMeta = metaData.getColumns( null, schema, object, column );
    String javaType = null;

    if( columnMeta.first() ) {
      int dataType = columnMeta.getInt( "DATA_TYPE" );
      javaType = SQLTypeMap.convert( dataType );
    }
    else {
      throw new Exception( "Unknown database column " + fullName + '.' );
    }

    return javaType;
  }