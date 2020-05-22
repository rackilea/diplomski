String strArray[] = { "Hey", "Hello there", "Hell no" };
String inputStr = "Hell";

for (int i = 0; i < strArray.length; i++) {
    String[] contents = strArray[i].split(" ");
    for (int j = 0; j < contents.length; j++) {
        if (inputStr.equals(contents[j])) {
            System.out.println(strArray[i]);
        }
    }
}