//get numerical value from the string (ex: AA from AA1)
private int getHorizentalPosition(String str) { 
    int result = 0;
    String s = "";
    for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if(Character.isLetter(c)) {
            result = result * 26;
            result = result + (c - 'A' + 1);
        }
    }
    return result;
}

//get string value from the numerical value
private static String getStringFormat(int horizentalIndex) {
    String s = "";
    while(horizentalIndex > 0) {
        int x = horizentalIndex % 26;
        if(x == 0) {
            s = s + 'Z';
        }
        else {
            s = s + (char)(x - 1 + 'A');
        }
        horizentalIndex = (horizentalIndex - 1) / 26;
    }
    return new java.lang.StringBuilder(s).reverse().toString();
}

//your out put
public String[] getHorizentals(String str1, String str2) {

    int first = getHorizentalPosition(str1);
    int last = getHorizentalPosition(str2);

    String[] res = new String[last - first + 1];
    for(int i = first; i <= last; i++) {
        res[i - first] = getStringFormat(i);
    }
    return res;
}