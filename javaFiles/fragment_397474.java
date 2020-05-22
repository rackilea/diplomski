static final String HEXES = "0123456789ABCDEF";
public static String getHex( byte [] raw ) {
  if ( raw == null ) {
    return null;
  }
  final StringBuffer hex = new StringBuffer( 2 * raw.length );
  for ( final byte b : raw ) {
    hex.append(HEXES.charAt((b & 0xF0) >> 4))
     .append(HEXES.charAt((b & 0x0F)));
  }
  return hex.toString();
}