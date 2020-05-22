int length = 60 * 8;
String passphrase = "mypasspharse";
String salt = "MySalt";
int iteration = 10;

SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
PBEKeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes("UTF-8"), iteration, length);

byte[] bytes = factory.generateSecret(spec).getEncoded();
for (int i = 0; i < 60; i++) {
    System.out.println(Integer.toHexString(bytes[i] & 0xFF));
}