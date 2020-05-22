public void loadData() throws IOException {
    List<String> namesList = new ArrayList<>();
    List<Double> someDoubleList = new ArrayList<>();

    BufferedReader CSVFile = new BufferedReader(new FileReader("/Users/leon/Desktop/Auto2.csv"));
    String data = CSVFile.readLine();

    while (data != null) {
        String[] dataArray = data.split(",");
        // Add the names to string list as the index of it is zero
        namesList.add(dataArray[0]);

        // Add the double value to double list as the index of it is six.
        someDoubleList.add(Double.parseDouble(dataArray[6]));
        data = CSVFile.readLine();
    }

    CSVFile.close();
}