public static void main(String[] args) {
    List<String> l = new ArrayList<String>();
    add("foo", l);
    add("foo", l);
    add("foo", l);
    add("foo", l);
    add("foo", l);
    add("foo", l);
    add("foo", l);
    add("foo", l);
    System.out.println(l);
}

static void add(String element, List<String> elements) {
    if (elements.contains(element)) {
        elements.add(nextValudFor(element, elements));
    } else {
        elements.add(element);
    }
}

static String nextValudFor(String element, List<String> elements) {
    for (char c = 'a'; c <= 'z'; c++) {
        String next = element + '_' + c;
        if (!elements.contains(next)) {
            return next;
        }
    }
    throw new IllegalStateException("Ran out of letters!");
}