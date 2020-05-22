/*
 * Constructor that takes the Morse Code as a String as a parameter
 */

public MorseString(String s) {
    if(!isValidMorse(s)) {
        throw new IllegalArgumentException("s is not a valid Morse Code");
    }
    // ...
}

/*
 * Factory method that takes the String as a parameter and converts it to Morse Code
 */

public static MorseString convert(String s) {
    // ...
    return new MorseString(convertedString);
}