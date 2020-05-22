int length = 3;
String input = "abcdefgh";
String circural = input + input.substring(0, length - 1);

for (int i = 0; i < input.length(); i++) {
    String part = circural.substring(i, i + length);
    System.out.println(part);
}