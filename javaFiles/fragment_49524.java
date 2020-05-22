public static void busRoutes() {
    Scanner sc = new Scanner(System.in);
    System.out.println("How many bus routes are there");
    int routes = sc.nextInt();
    String[][] array = new String[routes][4];
    for (int i = 0; i < routes; i++) {
        System.out.println("Please enter the bus route");
        System.out.println("What is the bus route");
        array[i][0] = sc.nextLine();
        System.out.println("Start Location");
        array[i][1] = sc.nextLine();
        System.out.println("End Location");
        array[i][2] = sc.nextLine();
        System.out.println("Who is the driver for bus route " + array[i][0]);
        array[i][3] = sc.nextLine();
    }
    decisionMaking(sc, array);
}