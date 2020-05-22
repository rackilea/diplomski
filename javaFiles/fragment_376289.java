public static String minValue() {

    Scanner input = new Scanner(System.in);

    System.out.print("How many first names are there?");
    int numOfNames = input.nextInt();
    String[] names = new String[numOfNames];
    double[] values = new double[numOfNames];
    for (int number = 0; number < numOfNames; number++) {
        System.out.print("Enter name: ");
        names[number] = input.next();
        System.out.print("Enter the value: ");
        values[number] = input.nextDouble();
    }

    int i = 0;
    // write a way to get the index i of the smallest value in values

    return names[i];
}