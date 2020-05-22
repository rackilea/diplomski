char input;
int[] myArray = new int[6];
Scanner console = new Scanner(System.in);
do {
    int roll = ThreadLocalRandom.current().nextInt(1, 6);
    System.out.println("Roll is " + roll);
    myArray[roll -1]++;
    System.out.println("Enter c to continue or enter q to quit ");
    input = console.nextLine().charAt(0);

} while (input == 'c' || input == 'C');
for(int i = 0; i < myArray.length; i++ ) {
    System.out.println(i + 1 + " occurs: " + myArray[i] + " times");
}