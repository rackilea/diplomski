// Use a base type in real code
private static Object parseNextVehicle(Scanner scanner) {
    String type = scanner.nextLine();
    if (type.equalsIgnoreCase("vehicle")) {
        return new Vehicle(scanner);
    } else if (type.equalsIgnoreCase("car")) {
        return new Car(scanner);
    }
    // ... throw an exception indicating an unknown vehicle type
}

// ... and then in the main method, use it like this:
while (scanner.hasNextLine()) {
    allVehicles.add(parseNextVehicle(scanner));
}