public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random(); 
    int[] numbers = new int[8];

    for(int i = 0; i < 8; i++) {
        numbers[i] = random.nextInt(50) + 1;
        System.out.print(numbers[i] + ", ");
    }

    System.out.print("\nInput value: ");
    int input = scanner.nextInt();
    boolean found = false;

    for(int i = 0; i < numbers.length; i++) {
        if(input == numbers[i]) {
            System.out.println("Index: " + i);
            found = true;
        }
    }

    if(!found) {
        System.out.println("none");
    }
}