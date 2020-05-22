private static List<String> diffList(List<String> mainList, List<String> secondList){
    List<String> list = new ArrayList<String>();
    Map<String, Integer> wordCount = new HashMap<>();
    for(String word: secondList) {
        if(mainList.contains(word)) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count == null) ? 1 : count + 1);
            if(wordCount.get(word) > 1){
                list.add(word);
            }
        }
    }
    return list;
}