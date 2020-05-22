public static String getMostAppropriate(String[] input) throws IOException{
    File file = new File("data.txt");
    Scanner scanner = new Scanner(file);
    ArrayList<Pair> pairs  = new ArrayList<>();
    int repetitions = 0;
    while (scanner.hasNextLine()) {
        String newLine = scanner.nextLine();
        String[] line = newLine.split(","); // this regex depends on your file format style,
        String oneSentence = "";
        for(String sentence : line){  // for sentence in file lines
            for(String string : sentence.split(" ")){  // for words in these sentences
                for(String word : input){  // for words from input
                    if(word.equals(string)){
                        repetitions += 1;
                        oneSentence = sentence;
                    }
                }
            }
            pairs.add(new Pair(repetitions,oneSentence));
            repetitions = 0;
        }
    }
    return mostCommon(pairs);
}