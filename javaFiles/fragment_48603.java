//create a HashMap containing the frequencys of every character of the String  (runtime O(n) )
public HashMap<Character, Integer> getFrequencys(String s){
    HashMap<Character, Integer> map = new HashMap<>();

    for(int i=0; i<s.length(); i++){
        //get character at position i
        char c = s.charAt(i);

        //get old frequency (edited: if the character is added for the 
        //first time, the old frequency is 0)
        int frequency;
        if(map.containsKey(c)){
            frequency = map.get(c);
        }else{
            frequency = 0;
        }
        //increment frequency by 1
        map.put(c, frequency+1 );
    }

    return map;
}