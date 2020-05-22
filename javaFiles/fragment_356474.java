public static void main(String[] args) {
    Random rand = new Random();
    int[] array = new int[5];
    int randomNumber;
    int i;

    System.out.println("Random numbers:");
    for (i = 0; i < 5; i++) {
        randomNumber = rand.nextInt(5) + 1;
        System.out.print(randomNumber);
        if (i < 4) {
            System.out.print(", ");
        }

        array[randomNumber - 1]++;
    }
    //výpis četnosti
    System.out.println("\n\nHistogram: "); 

    for (i = 0; i < array.length; i++) {
        System.out.println("Number " + (i + 1) + ": " + array[i] + ".");
    }
}