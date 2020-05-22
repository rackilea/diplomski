import java.util.Random;

public class Base64Stuff
{
    public static void main(String[] args) {
        Random random = new Random();
        byte[] randomBytes = new byte[32];
        random.nextBytes(randomBytes);

        String internalVersion = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(randomBytes);
        byte[] apacheBytes =  org.apache.commons.codec.binary.Base64.encodeBase64(randomBytes);
        String fromApacheBytes = new String(apacheBytes);

        System.out.println("Internal length = " + internalVersion.length());
        System.out.println("Apache bytes len= " + fromApacheBytes.length());
        System.out.println("Internal version = |" + internalVersion + "|");
        System.out.println("Apache bytes     = |" + fromApacheBytes + "|");
        System.out.println("internal equal apache bytes?: " + internalVersion.equals(fromApacheBytes));
    }
}