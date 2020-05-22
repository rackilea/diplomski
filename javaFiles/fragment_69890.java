List<String> sentences = new ArrayList<>();
    //int size =0;


    try{

        File file = new File("a2b.txt");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[.?!]");
        while(scanner.hasNext()){
            EachSentence = scanner.next();
            EachSentence = EachSentence.replaceAll("\\r?\\n", " ");
            EachSentence = EachSentence.trim();
            sentences.add(EachSentence);
        }
        scanner.close();

    }catch (IOException ex){ 
        System.out.println(ex.getMessage());
    }