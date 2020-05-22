Charset charset = Charset.forName("US-ASCII");
try (BufferedReader reader = Files.newBufferedReader(filename, charset)) {
    String line = null;
    while ((line = reader.readLine()) != null) {

        // THIS IS THE CODE FOR EVERY LINE
        String[] data = line.split(", ");
        int zipCode = Integer.parseInt(data[0]);
        String city = data[1];
        String state = data[2];
        double latitude = Double.parseDouble(data[3]);
        double longitude = Double.parseDouble(data[4]);
        ZipCode z1 = new ZipCode(zipCode, city, state, latitude, longitude);
        myZips.add(z1);

    }
} catch (IOException x) {
    System.err.format("IOException: %s%n", x);
} catch (NumberFormatException x) {
    System.err.format("NumberFormatException: %s%n", x);
}