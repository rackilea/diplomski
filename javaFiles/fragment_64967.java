Map<String, Set<String>> translations = new HashMap<>();
while (sc.hasNext()) {
    String entry = sc.next();
    translations.put(entry, translate(entry));
}
System.out.println(translations);