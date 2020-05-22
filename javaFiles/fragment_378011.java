private final static Scanner keyboard = new Scanner(System.in);
    private final static String[] stringArray = new String[10];

    public static void main(String[] args) {

        int stringNumber = 0;
        for (int i = 0; i < stringArray.length; i++) {

            System.out.println("\nEnter a string");

            String input = readNextItem();

            if(isInputExist(input)) {
                System.out.println("Item \"" + input + "\" already exists.");
                System.out.println("Try again.");
            } else {
                stringArray[stringNumber++] = input;
                System.out.println("\"" + input + "\"" + " has been stored.");
            }

            printArray(stringArray);
        }

    }

    private static String readNextItem() {
        return keyboard.next();
    }

    private static boolean isInputExist(String input) {

        for(String stored : stringArray) {
            if(input.equalsIgnoreCase(stored)) {
                return true;
            }
        }
        return false;
    }