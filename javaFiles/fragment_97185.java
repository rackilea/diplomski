public static void printDetails() {
    System.out.println("Current time: " + LocalTime.now());
    System.out.println("Current date: " + LocalDate.now());

    System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
    System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
}