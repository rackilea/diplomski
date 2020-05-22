public static int longest(ArrayList<String> data){

    int longString = 0;
    for(String s : data) {
        if (s.length() > longString)
            longString = s.length();
    }

    return longString;
}