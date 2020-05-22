protected Object convertValue( String prefix, String value ) {
    Object result = value;

    try {
      if( prefix.equalsIgnoreCase( PARAM_VARIABLE_PREFIX + "" ) ) {
        result = new String( value );
      }
      else if( prefix.equalsIgnoreCase( PARAM_VARIABLE_PREFIX + "timestamp_" ) ) {
        result = Timestamp.valueOf( value );
      }
      // ... etc.