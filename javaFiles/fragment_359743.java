public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    List<Integer> numbers = new ArrayList<>();

    int userInput, largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;

    System.out.println("This program takes a set of integers from the user, and then "
            + "outputs the results to the screen in four ways:");
    System.out.println("the order they were entered seperated by a comma and a space, "
            + "in ascending order, in descending order, and as Largest:Smallest.");
    System.out.println();
    // explain to the user what the program does, needs, etc.
    do {
        System.out.print("Please enter a number or -1 to end: ");
        userInput = input.nextInt();
        if (userInput != -1) {
            numbers.add(userInput);
            largest = Math.max(largest, userInput);
            smallest = Math.min(smallest, userInput);
        }
    } while (userInput != -1);

    // Prints the array contents as entered
    String sort = convertToString(numbers);
    System.out.println(sort);
    Collections.sort(numbers);
    System.out.println(convertToString(numbers));
    Collections.sort(numbers, Comparator.reverseOrder());
    System.out.println(convertToString(numbers));
    System.out.printf("Smallest = %d, Largest = %d%n", smallest, largest);
}