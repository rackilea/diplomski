private static String[] split(String delim, String line) {

    StringTokenizer tokens = new StringTokenizer(line, delim, true);
    String previous = delim;
    Vector v = new Vector();

    while (tokens.hasMoreTokens()) {
        String token = tokens.nextToken();

        if (!delim.equals(token)) {
            v.add(token);
        } else if (previous.equals(delim)) {
            v.add("");
        }
        previous = token;
    }

    return (String[]) v.toArray(new String[v.size()]);
}