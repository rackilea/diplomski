public static void main(String[] args) throws IOException {

    CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
    ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
    while ((nextLine = reader.readNext()) != null) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0;i<5;i++) { //i<5 is hardcoded; get actual function for number of columns
           list.add(nextLine[i]);
        }
        array.add(list);
    }
    // example for nested loop to display results
    for(x=0;x<array.size();x++) {
        for(y=0;y<array.get(x).size();y++) {
            System.out.print(array.get(x).get(y) + " ");
        }
        System.out.println(" ");
    }
    // example to display specific item
    System.out.println(array.get(1).get(1));
}