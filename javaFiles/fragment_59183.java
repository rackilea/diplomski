public static void main(String[] args) throws FileNotFoundException{

    printCounts("myth.txt", "Babylonia and Assyria");
    System.out.println();
    printCounts("someOther.txt", "Some Other Title");
    System.out.println();
    printCounts("another.txt", "Another Title");
    System.out.println();
}

public static void printCounts(String filename, String title) throws FileNotFoundException {

    String[] stringArray = new String[100];
    int[] intArray = new int[100];
    int currentWordIndex = 0;
    Scanner input = new Scanner(new File(filename));

    while (input.hasNext()) {
        String word = input.next();
        boolean alreadyExists = false;
        for (int i = 0; i < currentWordIndex; i++) {

            if (stringArray[i].equals(word)) {
                alreadyExists = true;
                intArray[i]++;
                break;
            }
        }

        if (!alreadyExists && currentWordIndex < 100) {
            stringArray[currentWordIndex] = word;
            intArray[currentWordIndex++] = 1;
        }
    }

    System.out.println(title);
    System.out.printf("%10s%10s\n", "Word", "Count");
    for (int i = 0; i < stringArray.length; i++) {
        System.out.printf("%10s%10d", stringArray[i], intArray[i]);
        System.out.println();
    }
}