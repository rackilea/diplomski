import java.security.SecureRandom;
import java.security.Security;


public class SHA1PRNG {
 //here i swapped out the bountycastle provider and used the spongycatle
   static {
      Security.addProvider(new org.spongycastle.jce.provider.BouncyCastleProvider());
}

public static void main(String[] args) throws Exception {

    SecureRandom rng = SecureRandom.getInstance("SHA1PRNG");
    rng.setSeed(711);

    int numberToGenerate = 999;
    byte randNumbers[] = new byte[numberToGenerate];

    rng.nextBytes(randNumbers);
    for(int j=0; j<numberToGenerate; j++) {
        System.out.print(randNumbers[j] + " ");
    }

}
}