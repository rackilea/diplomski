public static ArrayList<Book> readbooklist() {

    ArrayList<Book> booklist = new ArrayList<Book>();
    File file = new File("path/filename.fileextension");

    try {
        Scanner scnr = new Scanner(file);

        while (scnr.hasNextLine()) {
            String entry = scnr.nextLine();
            String [] parts = entry.split("\t"); // Depends on how data was delimited
            int series = Integer.parseInt(parts[0]);
            int intA = Integer.parseInt(parts[2]);
            int intB = Integer.parseInt(parts[3]);
            Book single = new Book(series, parts[1], intA, intB);
            booklist.add(single);
        }

        scnr.close();

    } catch (FileNotFoundException e) {
        System.out.println("File Not Found!");
    }

    return booklist;
}