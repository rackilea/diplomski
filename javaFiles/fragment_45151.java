String[] simpleArray;

private void loadFile() throws FileNotFoundException, IOException {
    File txt = new File("C:/A_WORDS/dictionary.txt");
    try (Scanner scan = new Scanner(txt)) {
        data = new ArrayList<>() ;
        while (scan.hasNextLine())
            data.add(scan.nextLine());

        simpleArray = data.toArray(new String[]{});
        int L = simpleArray.length;
        System.out.println("@@@ L "+L);
    }
}