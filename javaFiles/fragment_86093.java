// \xEF\xBC\xA1
byte[] utf8 = { (byte) 0xEF, (byte) 0xBC, (byte) 0xA1 };
String utf16 = new String(utf8, Charset.forName("UTF-8"));

// print the char as hex   
for(char ch : utf16.toCharArray()) {
    System.out.format("%02x%n", (int) ch);
}