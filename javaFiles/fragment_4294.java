String input = "-1 2 -4 6 8";
String[] numberStringArray = input.split(" ");

for (String s : numberStringArray) {
    int n = Integer.parseInt(s);
    System.out.println("n = " + n);
}