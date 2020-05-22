public static String noRawr(String str) // 7
{
    String result = str;

    for (int i = 0; i < result.length() - 3; ) {// I move i++ from here
        if (result.substring(i, i + 4).equals("rawr")) {
            result = result.substring(0, i) + result.substring(i + 4);
        }else{
            i++; //and place it here, to move to next position 
                 //only if there wont be any changes in string
        }
    }
    return result;
}