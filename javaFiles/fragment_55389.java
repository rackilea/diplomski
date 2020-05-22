System.out.println(camelSplit("ThisIsAFunkyCamelString"));

/** Returns a copy of s with a space in front of each capital letter. */

public String camelSplit(String s) {
    if (s == null || s.length < 2) {
        return s;
    }
    return s.substring(0, 1) + s.substring(1).replaceAll("([A-Z])", " $1");
}