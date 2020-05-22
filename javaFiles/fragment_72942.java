String input = "a";
String str = "ab,ac,ad,bb,bc,bd";
for (String s: str.split(",")) {
    if (s.startsWith(input)) {
        System.out.println("String " + s + " starts with " + input);
    }
}