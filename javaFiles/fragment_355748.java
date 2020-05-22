public static String[] getUnique(String[][] matrix) {
    Map<String, Integer> map = new LinkedHashMap<>();

    for (String[] row : matrix)
        for (String col : row)
            map.put(col, map.getOrDefault(col, 0) + 1);

    List<String> unique = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : map.entrySet())
        if (entry.getValue() == 1)
            unique.add(entry.getKey());

    return unique.toArray(new String[unique.size()]);
}