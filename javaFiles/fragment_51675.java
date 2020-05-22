while (scanner.hasNext()) {
    String type = scanner.nextLine();
    if (type.equalsIgnoreCase("vehicle")) {
        allVehicles.add(new Vehicle(scanner));
    } else if (type.equalsIgnoreCase("car")) {
        allVehicles.add(new Car(scanner));
    }
    // ...
}