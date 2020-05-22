NavigableMap<String, Boolean> wordmap = new TreeMap<String, Boolean>();
Random random = new Random(1);
for(int i=0;i<10*1000*1000;i++)
    wordmap.put(Long.toString(Math.abs(random.nextLong()), 36).substring(1), true);
String prefix = "abcd";
for (String word : wordmap.subMap(prefix, prefix+"\uffff").keySet()) {
    System.out.println(word + " starts with " + prefix);
}