public static int wordcount(String myString) {
    String[] newStringArr = myString.split("[\r\n]");
    int counter = myString.split("[\r\n]").length;
    for (String a : newStringArr) {
        counter = counter + (a.length() - a.replaceAll(" ", "").length());
    }
    return counter;
}