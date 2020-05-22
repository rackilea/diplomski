public static void main(String[] args) {

    int[] numbers;
    numbers = new int[10];
    int largest = numbers[0];
    int largest_i = 0;
    int counter;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Please enter 10 numbers: ");

    for (counter = 0; counter < numbers.length; counter++) {
        numbers[counter] = keyboard.nextInt();
        if (numbers[counter] >= largest) {
            largest = numbers[counter];
            largest_i = counter;
        }
    } 

    System.out.print("The largest number is: " + largest);
    System.out.println(" ");
    System.out.print("That number is stored at index " +  );
    } 
 }