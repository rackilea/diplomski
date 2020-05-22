public static int maxIndex;
    public static String[] birds = new String[10];
    public static int[] numbers = new int[10];

    public static void main(String[] param) {
        birdInput();
        most();
        System.exit(0);
    }

    public static void birdInput() {
        int i = 0;
        while (i <= birds.length) {
            System.out.println("What bird did you see?");
            birds[i] = inputCheck();
            System.out.println("How many did you see?");
            numbers[i] = Integer.parseInt(inputCheck()); //you should check here if its actuall a number otherwiese your programm will crash 
            i++;

        }
    }

    static String inputCheck() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.toUpperCase().equals("END")) {
            end();
        }
        return input;
    }


public static int getMaxIndex(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
        int newnumber = numbers[i];
        if ((newnumber > numbers.length)) {
            maxIndex = i;
        }
    }
    return maxIndex;

}

public static void end() {
     maxIndex = getMaxIndex(numbers);
    System.out.print("\nWell....I guess thanks for using this program?\n");
    System.out.print("\nThe most common bird that you saw was the " + birds[maxIndex] + " with " + numbers[maxIndex] + " being seen in total\n");
    System.exit(0);

}

public static void most() {
    System.out.println("fdff");
}
}