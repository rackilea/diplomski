public static void main(String[] args) {
    Vector<String> v = new Vector();

    v.addElement("hello");
    v.addElement("test");
    v.addElement("phytons");
    v.addElement("JAVA");
    v.addElement("Program");
    v.addElement("ultrons");

    System.out.println(keepShortest(v));
}

public static List<String> keepShortest(List<String> strings) {
    // Find length of shortest string
    int shortest = Integer.MAX_VALUE;
    for (String string : strings) {
        if (string.length() < shortest) {
            shortest = string.length();
        }
    }

    // Populate new list with shortest strings
    List<String> newList = new ArrayList<>();
    for (String string : strings) {
        if (string.length() == shortest) {
            newList.add(string);
        }
    }

    return newList;
}