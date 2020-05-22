public LibraryDB (File file) throws IOException {
//this next line was what I was missing...sigh.
    this.libraryItems = new HashMap<Integer, LibraryItem>();
        Scanner readFile = new Scanner(file);
        int barcode;
        String title;
        String author;
        while (readFile.hasNext()){
            barcode = Integer.parseInt(readFile.nextLine());
            title   = readFile.nextLine();
            author  = readFile.nextLine();
            LibraryItem authorTitleValues = new LibraryItem(title, author);
            libraryItems.put(Integer.valueOf(barcode), authorTitleValues);
            }
        readFile.close();
    }