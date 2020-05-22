public static void main(String args[]) {
    String[] a = {"1", "a", "b" };
    String [] res;
    List<String> b = new ArrayList<String>();
    Pattern p = Pattern.compile("(a|b)");
    Matcher m;
    for (int i=0; i<a.length; i++) {
        m = p.matcher(a[i]);
        if (m.matches()) {
            System.out.println("Match " + a[i]);
            b.add(a[i]);
        }
    }
    res = (String[]) b.toArray();
}