public void printFlightSchedule(OutputStream os) throws IOException {
    // Write...
}

public void printFlightSchedule(File file) throws IOException {
    FileOutputStream fis = null;
    try {
        fis = new FileOutputStream(file);
        printFlightSchedule(fis);
    } finally {
        try {

        } catch (Exception e) {
        }
    }
}

public void printFlightSchedule() throws IOException {
    printFlightSchedule(System.out);
}