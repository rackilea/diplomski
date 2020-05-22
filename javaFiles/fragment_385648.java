public static void main(String[] args) throws Exception {
    String data = "this \"is a test\" now \"hello\" goodbye";

    List<String> splits = new ArrayList();
    String current = "";
    boolean inQuote = false;        
    for (int i = 0; i < data.length(); i++) {
        if (data.charAt(i) == ' ' && !inQuote) {
            // Add your current split word and move on to the next character
            splits.add(current);
            current = "";
            continue; 
        } else if (data.charAt(i) == '\"') {
            // Flip the flag whenever you run across a quotation mark
            inQuote = !inQuote;
        }

        // Add current character to string, spaces never get added
        current += data.charAt(i);
    }
    // Add remaining split data from hitting the end of data
    if (!current.isEmpty()) {
        splits.add(current);
    }

    // Display results
    for (String split : splits) {
        System.out.println(split);
    }
}