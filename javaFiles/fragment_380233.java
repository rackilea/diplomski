int[] charCounts = new int[26];

    //Separate the string into individual words
    //The string " /n" tells it to look for spaces and newline characters "/n"
    StringTokenizer st = new StringTokenizer(inputString, " /n");

    //Loop until all the words are processed
    while (st.hasMoreTokens()) {

        //Select the next word
        String word = st.nextToken();

        //Convert the string to upper case so that lower case and upper case characters are represented the same
        word = word.toUpperCase();

        //Get the first character from the word
        char firstChar = word.charAt(0);

        //Convert the character to an integer representing it as an ASCII code
        int charCode = (int) firstChar;

        //Increment the count for that character by 1 
        //(We subtract 65 from the ASCII code because the array starts at 0 but 'A' is at 65)
        charCounts[charCode - 65]++;
    }

    //Obviously replace this section with whatever you like. It's just to show you how to get the values out again.
    for (int i = 0; i < charCounts.length; i++){
        System.out.println((char)(i + 65) + ": " + charCounts[i]);
    }