public class Test {

    //using a HashMap to keep count of all the words
    private static Map<String, Integer> countMap = new HashMap<String, Integer>();


    public static void main(String[] args) {
        LinkedHashMap<String, String> words1 = new LinkedHashMap<String, String>();
        words1.put("a", "movie good");
        words1.put("b", "song bad");
        words1.put("c", "music good");
        words1.put("d", "movie super");
        countWords(words1);

    }


    public static void countWords(LinkedHashMap word1){
        Set keys = word1.keySet();
        Iterator itr = keys.iterator();
        while(itr.hasNext()){
            String value = (String) word1.get(itr.next());
            String[] valueArray = value.split(" ");
            for(String s:valueArray){
                Integer count = countMap.get(s);
                if(count != null){
                    countMap.put(s, ++count);
                }else{
                    countMap.put(s, 1);
                }
            }
        }

        //print the final count of all the words
        for(Entry<String, Integer> entrySet: countMap.entrySet()){
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }

    }
}