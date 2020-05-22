public static boolean isInConstants(String yourString){
String[] sConsonantArray = new String[] {"q","w...}
for (String item : sConsonantArray) {
    if (yourString.equalsIgnoreCase(item)) {
        return true;

    } 
}
 return false;

}