public class PostalTest{
    public static void main(String args[]) {

        Scanner type = new Scanner(System.in);

        String object;
        Double weighte, weightl;

        System.out.println("\nWhat type of package do you have?\n");
        System.out.println("\nMin Weight = 1oz. -- Max weight = 3.5oz for Letters 13 oz for Envelopes\n");
        System.out.println("(1) - Envelope");
        System.out.println("(2) - Letter");

        System.out.print("Please enter your selection:\t");
        object = type.nextLine();