private double readDoubleFromFile(BufferedReader file) throws IOException {
    String numberAsString = file.readLine();
    if (numberAsString == null) {
        throw new IOException();
    }
    double number = Double.parseDouble(numberAsString);
    return number;
}