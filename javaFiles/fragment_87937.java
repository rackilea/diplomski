Scanner input = new Scanner(System.in);
String s = input.next().toUpperCase();
int ascii = s.charAt(0);
System.out.println(ascii);
for (int i = 1; i < s.length(); i++) {
    ascii = s.charAt(i - 1);
    System.out.println(s.charAt(i) - ascii);
}