public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String[] horseNames = { "#5 Gitty-Up", "#7 Lady Simmons", 
            "#6 Burning Peanutbutter", "#10 White Lightning",
            "#3 Bella", "#1 Meg The Stallion" };
    Horse[] horses = new Horse[horseNames.length];
    for (int i = 0; i < horseNames.length; i++) {
        System.out.printf("Input amount for %s:%n", horseNames[i]);
        float amt = sc.nextFloat();
        horses[i] = new Horse(horseNames[i], amt);
    }
    Arrays.sort(horses, Comparator.reverseOrder());
    System.out.println("The current race progress is :");
    for (int i = 0; i < horses.length; i++) {
        System.out.println(horses[i]);
    }
}