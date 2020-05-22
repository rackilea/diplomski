private static String[] concat(Object... stringOrArrays) {
    List<String> result = new ArrayList<String>();
    for (Object stringOrArray : stringOrArrays) {
        if (stringOrArray instanceof String) {
            result.add((String) stringOrArray);
        } else if (stringOrArray instanceof String[]) {
            Collections.addAll(result, (String[]) stringOrArray);
        } else if (stringOrArray == null) {
            results.add(null)
        } else {
            throw new RuntimeException(stringOrArray + " not a String or String[]");
        }
    }
    return result.toArray(new String[0]);
}