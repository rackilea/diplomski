public static int charNumTrans(char toBeTranslated){
    //Variable init
    int translated = 0;
    char guessedVariable;

    //Checking if between a and i
    if(toBeTranslated == 'a' || toBeTranslated == 'b' || toBeTranslated == 'c' || toBeTranslated == 'd' || toBeTranslated == 'e' 
|| toBeTranslated == 'f' || toBeTranslated == 'g' || toBeTranslated == 'h' || toBeTranslated == 'i'){ //Checking to see which array to use

        char[] dictionary = {'0','.','1','a','2','b','3','c','4','d','5','e','6','f','7','g','8','h','9','i'};
        return findValue(dictionary);

    //checking between j and s
    }else if(toBeTranslated == 'j' ||toBeTranslated == 'k' ||toBeTranslated == 'l' ||toBeTranslated == 'm' ||toBeTranslated == 'n' ||
         toBeTranslated == 'o' ||toBeTranslated == 'p' ||toBeTranslated == 'q' ||toBeTranslated == 'r' || toBeTranslated == 's'){//Checking to see if in between 

        char[] dictionary = {'0','j','1','k','2','l','3','m','4','n','5','o','6','p','7','q','8','r','9','s'};
        return findValue(dictionary);

    }else{//Everything else will be in this data set.

        char[] dictionary = {'0','t','1','u','2','v','3','w','4','x','5','y','6','z'};
        return findValue(dictionary);

    }

}

public static int findValue(char[] dictionary){
    guessedVariable = dictionary[1];
    while(dictionary[guessedVariable] != toBeTranslated){
         guessedVariable +=2;
    }

    // Assigns letter minus one of array. e.g. b = dictionary[5]. This will then assign dictionary[4] to translated.
    translated = Character.getNumericValue(dictionary[guessedVariable-1]); 
    return translated;
}