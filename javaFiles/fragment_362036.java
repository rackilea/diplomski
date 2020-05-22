protected Object convertValue( String prefix, String value ) {
  Class<?> c = getPrefixes().get( prefix );
  Object result = value;

  try {
    if( c == java.lang.String.class ) {
      result = new String( value );
    }
    else if( c == java.sql.Timestamp.class ) {
      result = Timestamp.valueOf( value );
    }
    else if( c == java.sql.Time.class ) {
      result = Time.valueOf( value );
    }
    else if( c == java.util.Date.class ) {
      DateFormat sdf = createDateFormat();
      result = sdf.parse( value );
    }
    else if( c == java.math.BigDecimal.class ) {
      result = new BigDecimal( value );
    }
    else if( c == java.lang.Integer.class ) {
      result = Integer.valueOf( value );
    }
    else if( prefix.equalsIgnoreCase( PARAM_VARIABLE_PREFIX + "array_int_" ) ) {
      result = parseIntegerArray( value );
    }
  }
  catch( Exception e ) {
    throw new RuntimeException( e );
  }

  return result;
}