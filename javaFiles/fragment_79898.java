String myList[] = {"Cat", "ate", "dog"};
String fin = "";

for (String conc : myList) {
    fin = fin + conc + " ";
}

//finally remove the last extra space
fin = fin.substring(0, fin.length()-1);