public String countMatches(String main) {
    //Create an array of the alphabets length
    main = main.toLowerCase();
    int[] foundArray = new int[26];
    String output = "";
    //Create an alphabets array
    String[] alphabets = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split("\\s");
    //Split the main String array
    String[] mainArray = main.split("");
    for (String string : mainArray) {
        //Iterate through the array
        for (int i = 0; i < alphabets.length; i++) {
            //If the string index matches any of our alphabets
            if (string.equals(alphabets[i])) {
                //Increase the corresponding foundArray index value
                foundArray[i] = foundArray[i] + 1;
            }
        }
    }
    //Iterate through the foundArray
    for (int i = 0; i < foundArray.length; i++) {
        //If an index is greater than 0
        if (foundArray[i] > 0) {
            //A match was found
            //Assign the matched foundArray index to the corresponding alphabet
            output += alphabets[i] + ":" + foundArray[i] + ", ";
        }
    }
    return output;
}