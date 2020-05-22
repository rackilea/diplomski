String str = "quick brown fox jumps over the lazy dog";
List<String> res = new ArrayList<String>();
String last = null;
String[] tok = str.split(" ");
for (int i = tok.length-1 ; i >= 0 ; i--) {
    if (last == null) {
        last = tok[i];
    } else {
        last = tok[i] + " " + last;
    }
    res.add(last);
}
for (String s : res) {
    System.out.println(s);
}