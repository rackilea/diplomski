long value = Integer.MAX_VALUE + 1234L;
System.out.println("original value    = " + value);

int iValue = (int)value;
System.out.println("value as int      = " + iValue);
byte[] array = new byte[4];

ByteBuffer buf = ByteBuffer.wrap(array);
buf.putInt(0, iValue);

int iRetrieved = buf.getInt(0);
System.out.println("int from buf      = " + iRetrieved);

long retrieved = iRetrieved;
System.out.println("converted to long = " + retrieved);

retrieved = retrieved & 0xFFFFFFFFL;
System.out.println("high bytes masked = " + retrieved);