public static void main(String[] args) {
    Map<String, Integer> wordMap = new TreeMap<String, Integer>();
    try {
        Scanner inputFile = new Scanner(new File("phrases.txt"));
        while(inputFile.hasNextLine()){
            String line = inputFile.nextLine();
            String[] words = line.split(" ");
            for(int i=0; i<words.length; i++){
                String word = words[i].trim();
                if(word.length()==0){
                    continue;
                }
                int count = 0;
                if(wordMap.containsKey(word)){
                    count = wordMap.get(word);
                }
                count++;
                wordMap.put(word, count);
            }
        }
        inputFile.close();
        for(Entry<String,Integer> entry : wordMap.entrySet()){
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}