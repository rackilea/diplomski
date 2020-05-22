import java.io.FileInputStream;
KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
// get user password and file input stream
char[] password = getPassword();
try (FileInputStream fis = new FileInputStream("C:/mykeystore.jks")) {
    ks.load(fis, password);
}