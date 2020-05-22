// Not a local variable
Map<String, String> queryValuess = new HashMap<String, String>();

private void Premii10(Map<String, String> map) {
    p1 = 5;
    String premiu1 = String.valueOf(p1);
    map.put("p1", premiu1.toString());
}

// Use it like this
button click event {
    Premii10(queryValuess);
}