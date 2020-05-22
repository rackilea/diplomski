public void createSubwords(String word) {
    // As you can see, your array must have (2^n) - 1 entries
    String[] subwords = new String[(int)Math.pow(2, word.length()) - 1];
    String bin;
    String fmt;
    String subword;
    for(int i = 1; i < Math.pow(2, word.length()); i++) {
        // fmt will be used to format the binary string so it is
        // left padded with zeros
        fmt = "%0" + word.length() + "d";
        // bin is the binary string
        bin = String.format(fmt, Long.parseLong(Integer.toBinaryString(i)));
        // Initialize the subword
        subword = "";
        // For each '1' in the binary string, add the matching character
        // to the subword
        for(int j = 0; j < bin.length(); j++) {
            if(bin.charAt(j) == '1')
                subword = subword + word.charAt(j);
        }
        // Store it in the array
        subwords[i - 1] = subword;
    }
    // Print each subword
    for(String s : subwords) {
        System.out.println(s);
    }
}