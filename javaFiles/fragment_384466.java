String  s = "BRAF.p:V600E";
Pattern p = Pattern.compile("(\\w+)\\.(\\w+):([a-zA-Z]+)(\\d+)([a-zA-Z]+)");
Matcher m = p.matcher(s);
if (m.matches()) {
    String[] parts = {m.group(1),
                      m.group(2),
                      m.group(3),
                      m.group(4),
                      m.group(5)};
    // Prints "[BRAF, p, V, 600, E]"
    System.out.println(Arrays.toString(parts));
} else {
    // The input String is invalid.
}