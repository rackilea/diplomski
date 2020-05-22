public static char getKeyCharacter(){

    Scanner inputStream = new Scanner(System.in);
    boolean stop = false;
    String firstPrompt, strKeyCharacter;
    char keyCharacter = ' ';

    while(!stop){

        firstPrompt = "Please enter a SINGLE character to act as key: ";
        System.out.println(firstPrompt);
        strKeyCharacter = inputStream.nextLine();

        //check if the input contains only 1 character
        boolean isSingleChar = (strKeyCharacter.length() == 1);
        //check if the input character is within the ASCII code of 97 (a) to 122 (z)
        boolean isValidChar = 
                strKeyCharacter.charAt(0) >= 97 &&
                strKeyCharacter.charAt(0) <= 122;

        if(isSingleChar && isValidChar){
            keyCharacter = strKeyCharacter.charAt(0);
            stop = true;
        }


    }

    return keyCharacter;
}