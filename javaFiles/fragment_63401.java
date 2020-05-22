int[] numbers = new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70};

System.out.print("Enter number you want to search from Array: ");
int userInput = scanner.nextInt();

int returnInput = Arrays.binarySearch(numbers, userInput);
if (returnInput >= 0)
    System.out.println("Binary Search found " + userInput +
            " at position " + returnInput);
/*
if statement to output user input was not found in array
 */
else
    System.out.println("Number entered was not found.");