public int longestPalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();  // letter groups
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i));
        if(map.containsKey(c))
            map.put(c, map.get(i) + 1);
        else
            map.put(c, 1);
    }

    boolean containsOddGroups = false;
    int ans = 0;
    for(int count : map.values()){
        if(count % 2 == 0)  // even group
            ans += count;
        else{  // odd group
            containsOddGroups = true;
            ans += count - 1;
        }
    }
    if(!containOddGroups)
        return ans;
    else
        return ans + 1;  // we can place one letter in the center of palindrome
}