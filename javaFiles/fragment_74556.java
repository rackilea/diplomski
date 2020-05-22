String[] myFields = new String[]{name, userID, email};  // put your fields in an array or list

// loop through each field and copy the data
for (String field : myFields) {
    byte[] stringBytes = field.getBytes();  // get bytes from string
    System.arraycopy(stringBytes, 0, myByteArr, bufferPosition, stringBytes.length);  // copy src to dest
    bufferPosition += stringBytes.length;  // advance index
}