List<String> l = ...
Iterator<String> it = l.iterator();
while (l.hasNext()) {
    String s = it.next();
    if (s.equals("42")) {
        l.remove();   // removes the string returned by last call to next()
    }
}