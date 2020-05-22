public String parseCode(Map<Character , String> morseAlphabet , String input){
    StringBuilder morse = new StringBuilder();

    //iterate over the indices of all characters in range
    for(int i = 0 ; i < input.length() ; i++)
        if(morseAlphabet.get(input.charAt(i)) == null)
            //the character has no valid representation in morse-alphabet
            throw new IllegalArgumentException("unknown sign: \\u" + (int) input.charAt(i));
        else
            //append the correct morsesign to the output
            morse.append(morseAlphabet.get(input.charAt(i)));

    return morse.toString();
}