public static boolean passwordLength(String password) {
    /* Declare a boolean variable to hold the result of the method */
    boolean correct = true;

    /* Declare an int variable to hold the count of each digit */
    int digit = 0; 

    if (password.length() < 8) {
        /* The password is less than 8 characters, return false */
        return false;
    }

    /* Declare a char variable to hold each element of the String */
    char element;

    /* Check if the password has 2 or more digits */
    for(int index = 0; index < password.length(); index++ ){

        /* Check each char in the String */
        element = password.charAt( index );

        /* Check if it is a digit or not */
        if( Character.isDigit(element) ){
            /* It is a digit, so increment digit */
            digit++;
        } // End if block

    } // End for loop 

    /* Now check for the count of digits in the password */
    if( digit < 2 ){
        /* There are fewer than 2 digits in the password, return false */
        return false;
    }

    /* Use a regular expression (regex) to check for only letters and numbers */
    /* The regex will check for upper and lower case letters and digits */
    if( !password.matches("[a-zA-Z0-9]+") ){
        /* A non-alphanumeric character was found, return false */
        return false;
    }

    /* All checks at this point have passed, the password is valid */
    return correct;

}