double d = 4.81;
String s = String.valueOf(d);

for (int i = s.indexOf(".") + 1; i < s.length(); i++) {
    int digit = Character.getNumericValue(s.charAt(i));
    System.out.println(digit);
}