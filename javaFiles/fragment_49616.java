//considering String3 is equals to something like "a---z"
public static String swap(String String3) {
    System.out.println(String3);

    //this stores "a" value
    String firstLetter = String3.substring(0, 1);
    System.out.println("first: " + firstLetter);

    //this stores "z" value
    String lastLetter = String3.substring(String3.length() - 1);
    System.out.println("last: " + lastLetter);

    /*
    this replaces in the String3 source the character which is
    equals to firstletter (= "a" value) for lastLetter (= "z" value)

    the String3 field, which is "a-z" is turned to "z-z"

    Then, the final value stored is "z-z" 
     */
    String a = String3.replace(firstLetter, lastLetter);
    System.out.println("a: " + a);

    /*
    this replaces in the String3 source the character which is
    equals to lastLetter (= "z" value) for firstLetter (= "a" value)

    the a field, which is "z-z" is turned to "a-a"

    Then, the final value stored is "a-a" 
     */
    String z = a.replace(lastLetter, firstLetter);
    System.out.println("z: " + z);

    /*
    by returning the field z you only will get the same character 
    at start and end.
     */
    return z;
}