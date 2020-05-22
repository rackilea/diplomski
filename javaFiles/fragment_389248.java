public static String replacePercentage(String oldString, String replacement) {
    int Percent = oldString.indexOf('%');
    if (Percent == -1) {
        return oldString;
    }
    int Percent2 = oldString.indexOf('%', Percent + 1);
    if (Percent2 == -1) {
        return oldString;
    }
    String newString = oldString.substring(0, Percent);
    newString += replacement; 
    newString += oldString.substring(Percent2 + 1);        
    return replacePercentage(newString, replacement);
}