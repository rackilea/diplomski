private static String FrontTwo(String str){
    String beginning = "";

    if (str.charAt(0) == 'a'){
        beginning += 'a';
    }
    if (str.charAt(1) == 'b'){
        beginning += 'b';
    }
    //go through any more exceptions

    //Concat beginning to the end
    return beginning + str.substring(2);