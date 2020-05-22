public class StackOverflow {

    public static void main(String[] args) {
        // Fields
        String myString = "StackOverFlow PF Apple FT Laptop HW";

        String[] tokens = myString.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            System.out.print(tokens[i]);
            // Every other token
            if (i % 2 == 0) {
                System.out.print(" is a " + convert(tokens[i + 1]));
                i++;
            }
            System.out.println();
        }

    }

    /**
     * convert method turns the abbreviations into long form
     */
    private static String convert(String s) {
        String str;
        switch (s) {
            case "PF":
                str = "Platform";
                break;
            case "FT":
                str = "Fruit";
                break;
            case "HW":
                str = "Hardware";
                break;
            default:
                str = "Unknown";
                break;
        }
        return str;
    }

}