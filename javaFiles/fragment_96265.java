public class ArrayTest {
    public static void main(String[] args) throws FileNotFoundException {
        String stringArray[][] = new String[10][4];

        Scanner scanInt = new Scanner(new File("File Path"));
        int n = 0; // for the number of instructions
        int displayCycle = 0; // cycle to be displayed

        if (scanInt.hasNext()) {
            n = scanInt.nextInt(); // number of instructions taken from file
            displayCycle = scanInt.nextInt(); // cycle number taken from file
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (scanInt.hasNext()) {
                    stringArray[i][j] = getStringValue(scanInt.nextInt());
                }
            }
        }

        // Printing the data
        for (String[] strArray : stringArray) {
            for (String s : strArray) {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }

    static String getStringValue(int number) {
        String value = null;
        switch (number) {
            case 0:
                value = "add";
                break;
            case 1:
                value = "sub";
                break;
            case 2:
                value = "mult";
                break;
            case 3:
                value = "div";
                break;
            default:
                value = "";
                break;
        }
        return  value;
    }
}