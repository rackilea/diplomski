String name = "jean-louis-patrice";
StringBuilder sb = new StringBuilder(name);
sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
int p = 0;
while ((p = sb.indexOf("-", p + 1)) != -1) {
    if (p + 1 < sb.length()) {
        sb.setCharAt(p + 1, Character.toUpperCase(sb.charAt(p + 1)));
    }
}
System.out.println(sb);