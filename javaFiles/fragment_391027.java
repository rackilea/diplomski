public void printAllSubWords(String prefix, String subword) {
    for(int i = 0; i < subword.length(); i++) {
        System.out.println(prefix + subword.charAt(i));
        printAllSubWords(prefix + subword.charAt(i), 
                         subword.substring(i + 1, subword.length()));
    }
}