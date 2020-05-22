//                           |first letters (1 to 3)
//                                        | if 3 letters precede...
//                                                         | digits (1 to 7)
//                                                                   | if 7 digits precede...
//                                                                               | 3 letters
Pattern p = Pattern.compile("[a-zA-Z]{1,3}((?<=[a-zA-Z]{3})\\d{1,7})?((?<=\\d{7})[a-zA-Z]{3})?");
String[] inputs = {"XYZ0001112CCC", "A", "AB", "ABC", "ABC12", "ABC123", "A1", "AB2", "ABCD123","ABC1234567XY1"};
Matcher m;
for (String input: inputs) {
    m = p.matcher(input);
    System.out.println("Input: " + input + " --> Matches? " + m.matches());
}