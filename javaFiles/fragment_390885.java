public static int countLetter(String name) {
    int count = 0;

    if(name != null && !name.isEmpty()) {
        /* This regular expression is splitting String at the
         * sequence of Non-alphabetic characters. Hence actually
         * splitting the Name into group of words */
        String[] tokens = name.split("[^a-zA-Z]+");
        for(String token : tokens) {
            count += token.length();
        }
    }

    return count;
}