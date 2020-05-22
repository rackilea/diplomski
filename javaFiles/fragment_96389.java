public boolean insert ( byte[] element ) {
  Log.i(TAG, "Inserting "+element[0]);
  // Take a copy of the element.
  byte[] b = new byte[element.length];
  System.arraycopy( element, 0, b, 0, element.length );
  boolean success = inBuffer.offer( b );
  return success;
}