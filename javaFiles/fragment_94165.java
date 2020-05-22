ObservableList<City> data = FXCollections.observableArrayList();
File file = new File("test.txt");
//Charset charset = StandardCharsets.US_ASCII;
Charset charset = StandardCharsets.UTF_8;
int currentId = 0;

try(BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream(file), charset))) {
    String line = reader.readLine();

    while (line != null) {
        data.add(new City(currentId, line));
        line = reader.readLine();
        currentId++;
    }
}