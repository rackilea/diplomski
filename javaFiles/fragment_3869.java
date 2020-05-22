public VocabularyTest() throws FileNotFoundException{
    System.out.println("In VocabularTest Constructor");
    words=new ArrayList<VocabularyWord>();
    ArrayList<String> str=new ArrayList<String>();
    File inputFile = new File("Vocabulary.txt");

    System.out.println(inputFile.getAbsolutePath());

    Scanner input = new Scanner(inputFile);
    while(input.hasNextLine()){
        System.out.println(input.nextLin());
    }