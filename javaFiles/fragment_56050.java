public static double Totalwallspace(int NumberofRooms) {
    try (Scanner scanner = new Scanner(System.in)) {
        double totalSquareFeet = 0;

        for (int currentRoom = 1; currentRoom <= NumberofRooms; currentRoom++) {
            System.out.println("Please enter the square feet of the wall space in room: " + currentRoom);
            totalSquareFeet += scanner.nextDouble();
        }

        return totalSquareFeet;
    }
}