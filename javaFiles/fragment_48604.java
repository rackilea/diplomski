//runtime O(3*n) = O(n)
public boolean compare(String s1, String s2){
    if(s1.length() != s2.length()){
        return false;
    }

    //runtime O(n)
    HashMap<Character, Integer> map1 = getFrequencys(s1);
    HashMap<Character, Integer> map2 = getFrequencys(s2);

    //Iterate over every character in map1 (every character contained in s1)  (runtime O(n) )
    for(Character c : map1.keySet()){
        //if the characters frequencys are different, the strings arent permutations
        if( map2.get(c) != map1.get(c)){
            return false;
        }
    }

    //since every character in s1 has the same frequency in s2,
    //and the number of characters is equal => s2 must be a permutation of s1

    return true;
}