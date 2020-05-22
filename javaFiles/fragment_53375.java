String key;
HashMap<String, Integer> freqMap = new HashMap<>();

while(inFile.hasNextLine()) {
    if(inFile.hasNextDouble()) {
        Double nextDouble = inFile.nextDouble();
        if(nextDouble >= 1250.0) {
            key = A;
            //either create a new key in the HashMap for A, B, etc. or increment the  
            //value associated with the existing key by one
            freqMap.merge(key, 1, Integer::sum);  
        }
        //we are going to use separate if statements as it appears that values can be in 
        //more than one category
        if(nextDouble < 1500.0 && nextDouble >= 1100.0) {
            key = B;
            freqMap.merge(key, 1, Integer::sum);  
        }
        and so on...
    }
}