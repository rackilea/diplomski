public static int SumPairs(Integer[] input, int k){
    Map<Integer, Integer> frequencies = new HashMap<>();
    int pairsCount = 0;      

    for(int i=0; i<input.length; i++){
        int value = input[i];
        int complement = k - input[i];

        if(frequencies.containsKey(complement)){                
            int freq = frequencies.get(complement) - 1;
            pairsCount++;
            //System.out.println(value + ", " + complement);    
            if(freq == 0){
                frequencies.remove(complement);
            }else{
                frequencies.put(complement, freq);
            }
        }else{
            if(frequencies.containsKey(value)){         
                frequencies.put(value, frequencies.get(value) + 1);             
            }else{
                frequencies.put(value, 1);
            }
        }
    }
    return pairsCount;
}