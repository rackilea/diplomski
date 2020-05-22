public static void printProcessorDetails() {
    System.out.println("Available processors: " + getAvailableProcessors());
}

public static int getAvailableProcessors() {
    return Runtime.getRuntime().availableProcessors();
}

public static void printMemoryDetails() {
    System.out.println("Max memory: " + getMaxMemory());
    System.out.println("Free memory: " + getFreeMemory());
}

public static long getFreeMemory() {
    return Runtime.getRuntime().freeMemory();
}

public static long getMaxMemory() {
    return Runtime.getRuntime().maxMemory();
}

private static void printDateTimeDetails() {
    System.out.println("Current time: " + LocalTime.now());
    System.out.println("Current date: " + LocalDate.now());
}