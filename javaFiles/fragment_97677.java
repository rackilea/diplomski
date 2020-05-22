String[] myStringArray = new String[]{"a", "b", "c"};
String myNewString = "";
for (int i = 0; i < myStringArray.length; i++) {
    if (i != 0) {
        myNewString += " " + myStringArray[i];
    } else {
        myNewString += myStringArray[i];
    }
}