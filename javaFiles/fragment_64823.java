StringBuilder sqlSelect = new StringBuilder( 1024 );
sqlSelect.append( "UPDATE test.selectiontable " )
         .append( "SET DTSStatusType_ti = 3, ")
         .append( "Queued_DialerIP_vch = ? " )
         .append( "WHERE DTSId_int IN ( " ); 

int paramCount = ids.size();
if( paramCount > 0 ) {
  for( i = 0; i < paramCount; i++ ) {
    sqlSelect.append( ( i > 0 ? ", ?" : "?" );
  } // for each param
  sqlSelect.append( " )" );
} // if ids list is not empty

// make the prepare statement (pst) with the above sql string
PreparedStatement pst = 
    connMain.prepareStatement( sqlStatement.toString() );

// now set the parameter values in the query
int paramIndex = 1;

pst.setString(paramIndex++, CurrRemoteIPAddress);

if( paramCount > 0 ) {
  for( i = 0; i < paramCount; i++ ) {
    pst.setLong( paramIndex++, 
                 ( (Integer)ids.get( i ) ).intValue() );
  } // for each param
} // if ids list is not empty

pst.executeUpdate();