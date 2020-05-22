public static void main(String[] args) throws IOException {
    String line;

    ArrayList<String> names = new ArrayList<>();
    String filename = "list.txt";
    File inputFile = new File(filename);
    FileReader file = new FileReader(inputFile);
    BufferedReader reader = new BufferedReader(file);
    // remove first line
    line = reader.readLine();

    while((line = reader.readLine()) != null){
        String[] words = line.split("\\t+");
        names.add(words[1]);
    }

    System.out.println(names);

    reader.close();
}