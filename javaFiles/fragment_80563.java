import java.util.Arrays;
import java.util.Scanner;

public class CharacterTranslation {

    public static void main(String[] args) {
        // Get Input from User...
        Scanner in = new Scanner (System.in);
        System.out.println("***  CONVERT FROM STRING TO ASCII TO BINARY TO ACGT  ***\n");
        System.out.println("Please enter a String to Convert to ACGT:");
        String inputString = in.nextLine();   

        // Declare and initialize required variables...
        int[] inputAscii = new int[inputString.length()];
        String[] inputBinary = new String[inputString.length()];
        // Translation Table made from a two dimensional Array:
        String[][] ACGTtranslation = {{"A","00"},{"T","01"},{"G","10"},{"C","11"}};

        // ------------------------------------------------
        // --------  CONVERT FROM STRING TO ACGT ----------
        // ------------------------------------------------

        //Convert the input string into ASCII numbers...
        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i); 
            inputAscii[i] = (int) character; 
        }

        System.out.println("Conversion To ASCII:  " + Arrays.toString(inputAscii)
                           .replace("[","").replace("]",""));

        //Convert the ASCII Numbers to 8 bit Binary numbers...
        for (int i = 0; i < inputAscii.length; i++) {
            String bs =  String.valueOf(Integer.toBinaryString(0x100 + 
                         inputAscii[i]).substring(2));
            // Pad the left end of the binary number with 0 should
            // it not be 8 bits. ASCII Charcters will only produce
            // 7 bit binary. We must have 8 bits to acquire a even
            // number of digit pairs for our ACGT convertion.
            while (bs.length() < 8) { bs = "0" + bs; }
            inputBinary[i] = bs; 
        }

        System.out.println("Conversion To 8bit Binary:  " + Arrays.toString(inputBinary)
                           .replace("[","").replace("]",""));

        //Convert the Binary String to ACGT format based from 
        // our translational Two Dimensional String Array.
        // First we append all the binary data together to form
        // a single string of binary numbers then starting from 
        // the left we break off 2 binary digits at a time to 
        // convert to our ACGT string format.

        // Convert the inputBinary Array to a single binary String...
        String binaryString = "";
        for (int i = 0; i < inputBinary.length; i++) {
            binaryString+= String.valueOf(inputBinary[i]);
        }
        // Convert the Binary String to ACGT...
        String ACGTstring = "";
        for (int i = 0; i < binaryString.length(); i+= 2) {
            String tmp = binaryString.substring(i, i+2);
            for (int j = 0; j < ACGTtranslation.length; j++) {
                if (tmp.equals(ACGTtranslation[j][1])) { 
                    ACGTstring+= ACGTtranslation[j][0];
                }            
            }
        }

        System.out.println("The ACGT Translation String for the Word '" +
                           inputString + "' is:  " + ACGTstring + "\n");


        // ------------------------------------------------
        // -----  CONVERT FROM ACGT BACK TO STRING --------
        // ------------------------------------------------

        System.out.println("***  CONVERT FROM ACGT (" + ACGTstring + 
                           "' TO BINARY TO ASCII TO STRING  ***\n");
        System.out.println("Press ENTER Key To Continue...");
        String tmp = in.nextLine();

        // Convert ACGT back to 8bit Binary...

        String translation = "";
        for (int i = 0; i < ACGTstring.length(); i++) {
            String c = Character.toString(ACGTstring.charAt(i)); 
            for (int j = 0; j < ACGTtranslation.length; j++) {
                if (ACGTtranslation[j][0].equals(c)) { translation+= ACGTtranslation[j][1]; break; }
            }
        }

        // We divide the translation String by 8 so as to get 
        // the total number of 8 bit binary numbers that would
        // be contained within that ACGT String. We then reinitialize
        // our inputBinary Array to hold that many binary numbers.
        inputBinary = new String[translation.length() / 8];
        int cntr = 0;
        for (int i = 0; i < translation.length(); i+= 8) {
            inputBinary[cntr] = translation.substring(i, i+8);
            cntr++;
        }
        System.out.println("Conversion from ACGT To 8bit Binary:  " + 
                           Arrays.toString(inputBinary).replace("[","")
                           .replace("]",""));

        //Convert 8bit Binary To ASCII...
        inputAscii = new int[inputBinary.length];
        for (int i = 0; i < inputBinary.length; i++) {
            inputAscii[i] = Integer.parseInt(inputBinary[i], 2);
        }

        System.out.println("Conversion from Binary To ASCII:  " + Arrays.toString(inputAscii)
                           .replace("[","").replace("]",""));

        // Convert ASCII to Character String...
        inputString = "";
        for (int i = 0; i < inputAscii.length; i++) {
            inputString+= Character.toString ((char) inputAscii[i]);
        }

        System.out.println("Conversion from ASCII to Character String:  " + inputString);
        System.out.println("**  Process Complete  ***");
    }
}