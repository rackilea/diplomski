private Map<String, int> freqWords = new HashMap<String, int>();

public void analyzeText(String text) {
   // You can split with another type of delimiter
   String regex = ....
   String[] inputs = text.split(regex); 

   for (String s : inputs) {
       if(freqWords.containtsKey(s)) {
           int frequency = inputs.get(s);
           frequency++;
           inputs.put(s, frequency);
       } else {
           inputs.put(s, 1);
       }
   }
}