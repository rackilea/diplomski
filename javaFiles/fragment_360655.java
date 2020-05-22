package arraycpr;

/**
 *
 * @author Mo
 */
public class ArrayCPR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] anArray;
        anArray = new String[6];
        anArray[0] = "260894-2931"; 
        anArray[1] = "200771-4672";
        anArray[2] = "290736-4960";
        anArray[3] = "251087-3729";
        anArray[4] = "290980-0121";
        anArray[5] = "250888-1544";

        for (String eachString : anArray) {
            System.out.println("CPR: " + eachString);
        }
    }
}