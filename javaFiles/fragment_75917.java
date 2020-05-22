StringBuilder hexStringBuilder = new StringBuilder(bytes.length * 2);
for(byte imageByte : bytes) {
    String hexByteString = Integer.toHexString(0x000000FF & (int)imageByte);
    if(hexByteString .size() == 1) {
        hexByteString = "0" + hexByteString ;
    }
    hexStringBuilder.append(hexByteString);
}
String hexString = hexStringBuilder.toString();
byte [] hexBytes = hexString.getBytes("UTF-8"); //Could also use US-ASCII