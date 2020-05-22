String s = "1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9", s1 = s.replaceAll("\\s+", "");
int len = s1.length();
System.out.println(s);
for (int i = 0; i < len; i += 4) {
    System.out.print(s1.charAt(i));
    if (i + 1 < len) {
        System.out.print(s1.charAt(i + 1));
    }
    if (i + 2 < len) {
        System.out.print(s1.charAt(i + 2));
    }
    if (i + 3 < len) {
        System.out.print(s1.charAt(i + 3));
    }
    System.out.println();
}