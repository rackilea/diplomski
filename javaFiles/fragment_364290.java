public class KeyGeneratorTest {
    public static void main(String[] args) {
        try {
            KeyGenerator keyGeneratorTest=KeyGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}