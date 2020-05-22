public static void main(String[] args) {
    List<SensorInfo> readings = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("client-temp.txt"))) {
        String line = br.readLine();

        while (line != null) {
            readings.add(new SensorInfo(line));
            line = br.readLine();
        }
    } catch (IOException e) {
        System.out.println("Unable to read data file");
        e.printStackTrace();
        System.exit(1);
    }

    String data = createStringFromInfo(readings);
    System.out.println("Lines: " + readings.size());
    writeFile("datastore.txt", data);
}