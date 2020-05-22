public static void main(String args[]) {
    String[] a = {"1", "a", "b" };
    List<String> b = new ArrayList<String>();
    for (int i=0; i<a.length; i++) {
        if (a[i].matches("(a|b)")) { // matches uses regex
            System.out.println("Match " + a[i]);
            b.add(a[i]);
        }
    }
}