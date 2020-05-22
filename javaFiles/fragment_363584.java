private ArrayList<Book> readBooks(String filename) {
        ArrayList<Book> lines = new ArrayList<>();
        Scanner s = null;
        File infile = new File(filename);
        try{
            FileInputStream fis = new FileInputStream(infile);
            s = new Scanner(fis);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        while(s.hasNextLine())
            lines.add(new Book(s.nextLine()));
        return lines;