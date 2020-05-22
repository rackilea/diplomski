// some dummy data
byte[] myByteArr = new byte[1024];
String name = "name";
String userId = "userId";
int bufferPosition = 0;

// repeat this for all of your fields...
byte[] stringBytes = name.getBytes();  // get bytes from string
System.arraycopy(stringBytes, 0, myByteArr, bufferPosition, stringBytes.length);  // copy src to dest
bufferPosition += stringBytes.length;  // advance index