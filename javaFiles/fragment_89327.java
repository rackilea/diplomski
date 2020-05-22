public static void main(String[] args) {
    //identifier declarations
    int number;
    int numberend = -99;
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;

    //create a Scanner object to read from input
    Scanner input = new Scanner(System.in);

    //display prompts and get input
    System.out.println("Enter an integer, or -99 to quit:");
    while ((number = input.nextInt()) != numberend) {

        System.out.println("Enter an integer, or -99 to quit:");

        if (number > largest) {
            largest = number;
        }
        if (number < smallest) {
            smallest = number;
        }

    }

    //largest & smallest
    System.out.println("Largest:" + largest);
    System.out.println("Smallest:" + smallest);

}