private static String strip(String s) {
    if (s.endsWith(":") || s.endsWith("-")){
        s = s.substring(0, s.length()-1);
    }
    return s;
}