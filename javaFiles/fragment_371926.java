Pattern pat = Pattern.compile("#([0-9a-f]{6})", Pattern.CASE_INSENSITIVE);
Matcher mat = pat.matcher(str);
while (mat.find()) {
    /* TODO something with mat.group()
     * with the given input String, you'd get:
     * #ff0000
     * #000000
     */
}