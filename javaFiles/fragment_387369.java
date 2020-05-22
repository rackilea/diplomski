Set<String> s1 = new HashSet<String>();
Set<String> s2 = new HashSet<String>();
List<Field> aFL = Arrays.asList(aF);
aFL.forEach(field -> {
    String temp = field.getName();
    s1.add(temp);
});
List<Field> bFL = Arrays.asList(bF);
bFL.forEach(field -> {
    String temp = field.getName();
    s2.add(temp);
});