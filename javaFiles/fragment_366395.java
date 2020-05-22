Trip makeTripWithNewName(String newName) {
    try {
        return new Trip(newName, this.gpsPoints);
    } catch (SpecialException exception) {
        // This code path will never be reached
        throw new RuntimeException(exception);
    }
}