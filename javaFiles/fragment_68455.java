public static int readArray(char[] words){
    char[] letters = new char[words.length];
    letters = myInput(); //get input message

    for ( int i = 0 ; i < letters.length ; i++)
         words[i] = letters[i] ; //store message to array of words

    return letters.length;
}