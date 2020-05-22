ResultSetMetaData meta = resultSet.getMetaData();
for( int i = 1; i <= meta.getColumnCount(); ++i ) {
  //check the type of the column, you might want to check more types than VARCHAR
  if( meta.getColumnType( i ) == VARCHAR ) {
    //check for the value "abc"
    if( "abc".equals( resultSet.getString( i ) ) ) {
      //found it
    }
  }
}