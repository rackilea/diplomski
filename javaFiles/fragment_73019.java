public static void printLocation() {

    // index 0 = North, index 1 = East, index 2 = South, index 3 = West
    System.out.println("Enter the sequence"); //eg - LRFFRRLRLF
    Scanner scan = new Scanner(System.in);
    String sequence = scan.nextLine();

    char[] sequenceArray = sequence.toCharArray();

    int index = 0, x = 0, y = 0;
    int i = 0;
    while (i < sequenceArray.length) {       

        String token = String.valueOf(sequenceArray[i]);
        i++;

        if (token.equals("R")) {
            index = index + 1;
        }
        if (token.equals("L")) {
            index = index - 1;
        }           

        if (index > 3 && index % 3 != 0) {
            index = index % 3 - 1;
        } else if (index > 3 && index % 3 == 0) {
            index = 3;
        }

        if (token.equals("F")) {
            if (index == 0) {
                y = y + 1;
            }
            if (index == 1) {
                x = x + 1;
            }
            if (index == 2) {
                y = y - 1;
            }
            if (index == 3) {
                x = x - 1;
            }
        }            
    }
    System.out.println("(" + x + "," + y + ")");
}