tokens.stream().collect(() -> new ArrayList<String>(), (l, e) -> {
    if(l.isEmpty() || !l.get(l.size()-1).toUpperCase().endsWith("STOP"))
        l.add(e);
}, (l1, l2) -> {
    if(l1.isEmpty() || !l1.get(l1.size()-1).toUpperCase().endsWith("STOP"))
        l1.addAll(l2);
});