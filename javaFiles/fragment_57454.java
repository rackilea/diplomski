public static int[] generateSubtraction() {

        Random rand2 = new Random();
        Scanner keyboard4 = new Scanner(System.in);

        int max = 100;
        int min = 1;

        int random = rand2.nextInt(50);
        int random2 = rand2.nextInt(50);

        int n = random - random2;
        System.out.println(random + " - " + random2 + " = ?");
        int x = keyboard4.nextInt();
        int[] numbers={n,x};
        return numbers;
}