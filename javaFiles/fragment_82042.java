long maxAsLong = 4294967295L; // Unsigned int max value
System.out.println("maxAsLong = " + maxAsLong);

int max = (int) maxAsLong;
System.out.println("max (unsigned) = " + Integer.toUnsignedString(max) +
                                 " = " + Integer.toUnsignedString(max, 16));
System.out.println("max (signed) = " + Integer.toString(max) +
                               " = " + Integer.toString(max, 16));

byte[] maxBytes = ByteBuffer.allocate(4).putInt(max).array();
System.out.print("maxBytes (unsigned): ");
for (byte b : maxBytes)
    System.out.print(Byte.toUnsignedInt(b) + " ");
System.out.println();
System.out.print("maxBytes (signed): ");
for (byte b : maxBytes)
    System.out.print(b + " ");
System.out.println();

int max2 = ByteBuffer.allocate(4).put(maxBytes).rewind().getInt();
System.out.println("max2 (unsigned) = " + Integer.toUnsignedString(max2) +
                                  " = " + Integer.toUnsignedString(max2, 16));