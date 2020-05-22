Map<String, Integer> unique = new HashMap<String, Integer>();
   for(String s: sentenceStat) {
       Integer cnt = unique.get(s);
       if (cnt == null) {
           unique.put(s, 1);
       } else {
           unique.put(s, cnt + 1);
       }
   }
   for(Map.Entry<String, Integer> key : unique.entrySet()){
       String key = entry.getKey();
       int cnt = entry.getValue();
       double betaw = topicWordCount[tIndex][word2IdVocabulary.get(key)] + beta;
       for (int m = 0; m < cnt; m++) {
           expectWT *= (betaw + m) / (beta0 + m0);
           m0++;
       }
   }