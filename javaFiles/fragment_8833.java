public static void main(String[] arges) {
    Scanner turtle = new Scanner(System.in);
    String[] calender = { "S", "M", "T", "W", "Th", "F", "S" };
    System.out.println("How many Employee's do you have?: ");
    int NUMBER_OF_EMPLOYEES = turtle.nextInt();
    turtle.nextLine();
    int [][]hours;
    hours = new int[NUMBER_OF_EMPLOYEES][7];
    String[][] employee = new String[NUMBER_OF_EMPLOYEES][2];
    // input for Names
    for (int x = 0; x < (employee.length); x++) {
        System.out.println("Name of Employee " + (x + 1) + ": ");
        String name = turtle.nextLine();
        employee[x][1] = name;

    }
    // input for Hours
    for (int z = 0; z < hours.length; z++) {
        System.out.println("Starting from Sunday Enter the hours Employee "+ (z + 1)+ " have worked (Make sure you seperate it by spaces): ");
        for (int a = 0; a < (hours[0].length); a++) {
            hours[z][a] = turtle.nextInt();
        }
    }
    // Print everything out
    for (int i = 0; i < employee.length; i++) {
        for (int z = 0; z < employee[0].length; z++) {
            System.out.print(employee[i][z] + "-");
        }
        for (int f = 0; f < NUMBER_OF_EMPLOYEES; f++) {

            System.out.print(" " + hours[i][f]);

        }
    }
    // Total hours.
    for (int s = 0; s < hours[0].length; s++) {
        int counter = 0;
        for (int d = 0; d < hours.length; d++) {
            hours[d][s] += counter;
        }
        System.out.println("Employee " + (s + 1) + ":" + counter + " Hours");
    }

}