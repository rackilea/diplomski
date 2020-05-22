Map<String, Set<String>> map = new TreeMap<String, Set<String>>();
for (Locale locale : Locale.getAvailableLocales()) {
    SimpleDateFormat fmt = ((SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, locale));
    String pattern = fmt.toPattern().replaceAll("\\P{L}", "").replaceAll("(.)\\1+", "$1");
    Set<String> set = map.get(pattern);
    if (set == null)
        map.put(pattern, set = new TreeSet<String>());
    set.add(locale.getDisplayName(Locale.US));
}
for (Entry<String, Set<String>> entry : map.entrySet())
    System.out.println(entry.getKey() + " = " + entry.getValue());