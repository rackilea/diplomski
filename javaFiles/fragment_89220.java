String[] singleBinaryArray = binary.toString().split("\\s");
String finalResult = "";
for (String string : singleBinaryArray) {
Character c = (char) Integer.parseInt(string, 2);
    finalResult += c.toString();
}
System.out.println("String " + finalResult);