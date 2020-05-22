if (length > 2 
        && (word.substring(length - 2).equals(",\"") 
        || word.substring(length - 2).equals(".\"")
        || word.substring(length - 2).equals("?\"") 
        || word.substring(length - 2).equals("!\""))) {
        unpunctWord = word.substring(0, length - 2);