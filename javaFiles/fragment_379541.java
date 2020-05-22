byte b = (byte) (0b11010100 << 1);
System.out.println(b); // -88. It is not possible to print 168 when printing a byte.
int asUnsigned = b & 0xFF;
System.out.println(asUnsigned); // 168.

// or in one go:

System.out.println(((byte) (0b11010100 << 1)) & 0xFF); // 168