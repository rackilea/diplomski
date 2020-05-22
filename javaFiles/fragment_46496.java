public static void allCombinations(String s, int i){
    if (i < s.length()){
        // Make a recursive call without removing the character
        allCombinations(s, i + 1);

        if (s.charAt(i) == '%'){
            // Remove character at index i and make a recursive call with new string
            String temp = s.substring(0, i) + s.substring(i + 1);
            allCombinations(temp, i);
        }

    }
    else{
        // print the combination found.
        System.out.println(s);
    }
}