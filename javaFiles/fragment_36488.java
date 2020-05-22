public ArrayList<ArrayList<String>> getCSVContent(String filepath) throws Exception {
    CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
    ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) { // 5 is the number of columns
            list.add(nextLine[i]);
        }
        array.add(list);
    }
    reader.close();
    return array;
}