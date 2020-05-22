private static String[] getMatches(String[] strings) {
    Pattern p = Pattern.compile("(a|b)");
    List<String> matches = new ArrayList<String>();

    for (String s : strings) {
        if (p.matcher(s).matches()) {
            matches.add(s);
        }
    }

    return (String[]) matches.toArray();
}