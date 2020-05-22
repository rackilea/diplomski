Scanner input = new Scanner(System.in);

System.out.println("Please enter the number of courses you have left: ");
int size = input.nextInt();
System.out.println("Enter the number of CUs for each course: ");
int totalSum = 0;
for (int i = 0; i < size; i++) {

    totalSum+=input.nextInt();
}

System.out.print("The sum of the numbers is: " + totalSum);