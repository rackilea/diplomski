public static List<String> splitWithCommaOutsideBrackets(String input) {
    int BracketCount = 0;
    int start = 0;
    List<String> result = new ArrayList<>();
    for(int i=0; i<input.length(); i++) {
        switch(input.charAt(i)) {
        case ',':
            if(BracketCount == 0) {
                result.add(input.substring(start, i).trim());// Trims the item!
                start = i+1;
            }
            break;
        case '[':
            BracketCount++;
            break;
        case ']':
            BracketCount--;
            if(BracketCount < 0) 
                return result; // The BracketCount shows the [ and ] number is unbalanced
            break;
        }
    }
    if (BracketCount > 0)
        return result; // Missing closing ]
    result.add(input.substring(start).trim()); // Trims the item!
    return result;
}