// iterating over the items of your own static array (without fast enumeration)
for (int i = 0; i < symbolsAndLetters.length; i++) {
    // initializing a new String and assigning it the value of your array
    // that is currently indexed in your for-loop
    String str = symbolsAndLetters[i];
    // replacing the String's content by replacing its value 
    // (1st parameter, the "str" value itself)
    // with an empty String
    str = str.replace(str, ""); 
}