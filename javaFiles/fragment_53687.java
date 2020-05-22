public static void main(String[] args) {
    int[] mergedArray = {};
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the name of your first file (including file extension): ");
    String filename1 = input.next();
    System.out.println("Enter the name of your second file (including file extension): ");
    String filename2 = input.next();
    int[] firstArray = null;
    int[] secondArray = null;
    try {
        Scanner in = new Scanner(new File(filename1));
        int count = in.nextInt();
        firstArray = new int[count];
        firstArray[0] = count;
        for (int i = 0; in.hasNextInt() && count != -1 && i < count; i++) {
            firstArray[i] = in.nextInt();
        }
    } catch (final FileNotFoundException e) {
        System.out.println("That file was not found. Program terminating...");
        e.printStackTrace();
    }
    try {
        Scanner in2 = new Scanner(new File(filename2));
        int count = in2.nextInt();
        secondArray = new int[count];
        secondArray[0] = count;
        for (int i = 0; in2.hasNextInt() && count != -1 && i < count; i++) {
            secondArray[i] = in2.nextInt();
        }
    } catch (final FileNotFoundException e) {
        System.out.println("That file was not found. Program terminating...");
        e.printStackTrace();
    }
    // do the merge operation with the 2 arrays
}