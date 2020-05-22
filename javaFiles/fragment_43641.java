import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
   /*
    * This program executes the Diffie-Hellman key agreement protocol between
    * 5 parties: Alice, Bob, Carol, Sara and Dave using a shared 2048-bit DH parameter.
    */
    public class DHKeyAgreement5 {
        private DHKeyAgreement5() {}
        public static void main(String argv[]) throws Exception {


        // Alice creates her own DH key pair with 2048-bit key size
            KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance("DH");
            aliceKpairGen.initialize(2048);
            KeyPair aliceKpair = aliceKpairGen.generateKeyPair();
        // This DH parameters can also be constructed by creating a
        // DHParameterSpec object using agreed-upon values
            DHParameterSpec dhParamShared = ((DHPublicKey)aliceKpair.getPublic()).getParams();
        // Bob creates his own DH key pair using the same params
            KeyPairGenerator bobKpairGen = KeyPairGenerator.getInstance("DH");
            bobKpairGen.initialize(dhParamShared);
            KeyPair bobKpair = bobKpairGen.generateKeyPair();
        // Carol creates her own DH key pair using the same params
            KeyPairGenerator carolKpairGen = KeyPairGenerator.getInstance("DH");
            carolKpairGen.initialize(dhParamShared);
            KeyPair carolKpair = carolKpairGen.generateKeyPair();
        // Sara creates her own DH key pair using the same params
            KeyPairGenerator saraKpairGen = KeyPairGenerator.getInstance("DH");
            saraKpairGen.initialize(dhParamShared);
            KeyPair saraKpair = saraKpairGen.generateKeyPair();
                    // Dave creates her own DH key pair using the same params
            KeyPairGenerator daveKpairGen = KeyPairGenerator.getInstance("DH");
            daveKpairGen.initialize(dhParamShared);
            KeyPair daveKpair = daveKpairGen.generateKeyPair();



          //Alice initialize
          KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
          //Alice computes gA
          aliceKeyAgree.init(aliceKpair.getPrivate());

          //Bob initialize
          KeyAgreement bobKeyAgree = KeyAgreement.getInstance("DH");
          //Bob computes gB
          bobKeyAgree.init(bobKpair.getPrivate());

          //Carol initialize
          KeyAgreement carolKeyAgree = KeyAgreement.getInstance("DH");
          //Carol computes gC
          carolKeyAgree.init(carolKpair.getPrivate());

          //Sara initialize
          KeyAgreement saraKeyAgree = KeyAgreement.getInstance("DH");
          //Sara computes gS
          saraKeyAgree.init(saraKpair.getPrivate());

          //Dave initialize
          KeyAgreement daveKeyAgree = KeyAgreement.getInstance("DH");
          //Sara computes gS
          daveKeyAgree.init(daveKpair.getPrivate());


          //First Pass

          //Alice computes gDA
          Key gDA = aliceKeyAgree.doPhase(daveKpair.getPublic(), false);

          //Bob computes gAB
          Key gAB = bobKeyAgree.doPhase(aliceKpair.getPublic(), false); 

          //Carol computes gBC
          Key gBC = carolKeyAgree.doPhase(bobKpair.getPublic(), false); 

          //Sara computes gCS
          Key gCS = saraKeyAgree.doPhase(carolKpair.getPublic(), false);

          //Dave computed gSD
          Key gSD = daveKeyAgree.doPhase(saraKpair.getPublic(), false);


          //Second Pass

          //Alice computes gSDA
          Key gSDA = aliceKeyAgree.doPhase(gSD, false);

          //Bob computes gDAB
          Key gDAB = bobKeyAgree.doPhase(gDA, false);

          //Carol computes gABC
          Key gABC = carolKeyAgree.doPhase(gAB, false);

          //Sara computes gBCS
          Key gBCS = saraKeyAgree.doPhase(gBC, false); 

          //Dave computes gCSD
          Key gCSD = daveKeyAgree.doPhase(gCS, false); 

          //Third Pass

          //Alice computes gCSDA
          Key gCSDA = aliceKeyAgree.doPhase(gCSD, false); 

          //Bob computes gSDAB
          Key gSDAB = bobKeyAgree.doPhase(gSDA, false); 

          //Carol computes gDABC
          Key gDABC = carolKeyAgree.doPhase(gDAB, false); 

          //Sara Computes gABCS
          Key gABCS = saraKeyAgree.doPhase(gABC, false); 

          //Dave computes gBCSC
          Key gBCSD = daveKeyAgree.doPhase(gBCS, false); 

          //Fourth Pass

          //Alice computes gBCSDA
          Key gBCSDA = aliceKeyAgree.doPhase(gBCSD, true); //This is Alice's secret

          //Bob computes gSDABC
          Key gCSDAB = bobKeyAgree.doPhase(gCSDA, true); //This is Bob's secret

          //Carol computes gSABC
          Key gSDABC = carolKeyAgree.doPhase(gSDAB, true); //This is Carol's secret

          //Sara Computes gABCS
          Key gDABCS = saraKeyAgree.doPhase(gDABC, true); //This is Sara's secret


          Key gABCSD = daveKeyAgree.doPhase(gABCS, true); //This is Dave's secret



        // Alice, Bob, Carol and Sara compute their secrets
            byte[] aliceSharedSecret = aliceKeyAgree.generateSecret();
            System.out.println("Alice secret: " + toHexString(aliceSharedSecret));

            byte[] bobSharedSecret = bobKeyAgree.generateSecret();
            System.out.println("Bob secret: " + toHexString(bobSharedSecret));

            byte[] carolSharedSecret = carolKeyAgree.generateSecret();
            System.out.println("Carol secret: " + toHexString(carolSharedSecret));

            byte[] saraSharedSecret = saraKeyAgree.generateSecret();
            System.out.println("Sara secret: " + toHexString(saraSharedSecret));

          byte[] daveSharedSecret = daveKeyAgree.generateSecret();
            System.out.println("Dave secret: " + toHexString(daveSharedSecret));

        // Compare Alice and Bob
            if (!java.util.Arrays.equals(aliceSharedSecret, bobSharedSecret))
                System.out.println("Alice and Bob differ");//    throw new Exception("Alice and Bob differ");
            else
                System.out.println("Alice and Bob are the same");
        // Compare Bob and Carol
            if (!java.util.Arrays.equals(bobSharedSecret, carolSharedSecret))
                System.out.println("Bob and Carol differ");//throw new Exception("Bob and Carol differ");
            else
                System.out.println("Bob and Carol are the same");
          //Compare Carol and Sara
            if (!java.util.Arrays.equals(carolSharedSecret, saraSharedSecret))
                System.out.println("Carol and Sara differ");//throw new Exception("Carol and Sara differ");
            else
                System.out.println("Carol and Sara are the same");
          //Compare Sara and Dave
          if (!java.util.Arrays.equals(saraSharedSecret, daveSharedSecret))
                System.out.println("Sara and Dave differ");//throw new Exception("Carol and Sara differ");
            else
                System.out.println("Sara and Dave are the same");

        }
    /*
     * Converts a byte to hex digit and writes to the supplied buffer
     */
        private static void byte2hex(byte b, StringBuffer buf) {
            char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                                '9', 'A', 'B', 'C', 'D', 'E', 'F' };
            int high = ((b & 0xf0) >> 4);
            int low = (b & 0x0f);
            buf.append(hexChars[high]);
            buf.append(hexChars[low]);
        }
    /*
     * Converts a byte array to hex string
     */
        private static String toHexString(byte[] block) {
            StringBuffer buf = new StringBuffer();
            int len = block.length;
            for (int i = 0; i < len; i++) {
                byte2hex(block[i], buf);
                if (i < len-1) {
                    buf.append(":");
                }
            }
            return buf.toString();
        }
    }