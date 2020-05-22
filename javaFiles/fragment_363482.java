String plainText = "hello world, there are sheep";
Charset charSet = Charset.forName("UTF-8");
byte[] plainBytes = plainText.getBytes(charSet);
String key = "secret";
byte[] keyBytes = key.getBytes(charSet);

byte[] cipherBytes = new byte[plainBytes.length];
for (int i = 0; i < plainBytes.length; i++) {

    cipherBytes[i] = (byte) (plainBytes[i] ^ keyBytes[i
            % keyBytes.length]);
}
String cipherText = new String(cipherBytes, charSet);
System.out.println(cipherText);