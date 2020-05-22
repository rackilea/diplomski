public static String formatString(SortedMap<TimeUnit, Integer> parts) {
    StringBuilder result = new StringBuilder(".");
    String sep = "", nextSep = " and ";
    for (Map.Entry<TimeUnit, Integer> e: parts.entrySet()) {
        TimeUnit field = e.getKey();
        Integer quantity = e.getValue();
        if (quantity > 0) {
            result.insert(0, sep)
                  .insert(0, field.toString().toLowerCase())
                  .insert(0, ' ')
                  .insert(0, quantity);
            sep = nextSep;
            nextSep = ", ";
        }
    }
    return result.toString();
}