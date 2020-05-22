public static void main(String[] args) throws Exception {
    String s = "-52/ABC/35/BY/200/L/DEF/307/C/110/L";
    // Pattern to find all 3 letter words . The \\b means "word boundary", which ensures that the words are of length 3 only. 
    Pattern p = Pattern.compile("(\\b[a-zA-Z]{3}\\b)");
    Matcher m = p.matcher(s);
    Map<String, Integer> countMap = new HashMap<>();
    // COunt how many times each 3 letter word is used.
   // Find each 3 letter word.
    while (m.find()) {
        // Get the 3 letter word.
        String val = m.group();
        // If the word is present in the map, get old count and add 1, else add new entry in map and set count to 1
        if (countMap.containsKey(val)) {
            countMap.put(val, countMap.get(val) + 1);
        } else {
            countMap.put(val, 1);
        }
    }
    System.out.println(countMap);
    // Get ABC.. and DEF.. using positive lookahead for a 3 letter word or end of String 
    // Finds and selects everything starting from a 3 letter word until another 3 letter word is found or until string end is found.
    p = Pattern.compile("(\\b[a-zA-Z]{3}\\b.*?)(?=/[A-Za-z]{3}|$)");
    m = p.matcher(s);
    while (m.find()) {
        String val = m.group();
        System.out.println(val);
    }

}