public static void main(String[] args) {

        List<String> word_list = new ArrayList<>();
        //Load your words to the word_list here

        //Find the unique words now from list
        String[] uniqueWords = word_list.stream().distinct().
                                       toArray(size -> new String[size]);
        Map<String, Integer> wordsMap = new HashMap<>();
        int frequency = 0;

        //Load the words to Map with each uniqueword as Key and frequency as Value
        for (String uniqueWord : uniqueWords) {
            frequency = Collections.frequency(word_list, uniqueWord);
            System.out.println(uniqueWord+" occured "+frequency+" times");
            wordsMap.put(uniqueWord, frequency);
        }

       //Now, Sort the words with the reverse order of frequency(value of HashMap)
       Stream<Entry<String, Integer>> topWords = wordsMap.entrySet().stream().
         sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).limit(5);

        //Now print the Top 5 words to console
        System.out.println("Top 5 Words:::");
        topWords.forEach(System.out::println);
 }