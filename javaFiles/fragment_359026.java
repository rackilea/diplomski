public Map<String, Map<String, String>> getData(final String query) {
    final Map<String, Map<String, String>> results = new HashMap<>();

    try (final Statement stmt = this.conn.createStatement(); final ResultSet rs = stmt.executeQuery(query);) {
        final ResultSetMetaData rsmd = rs.getMetaData();
        long rId = 0;
        while (rs.next()) {
            final Map<String, String> record = new HashMap<>();
            for (int i = 1; i < (rsmd.getColumnCount() + 1); i++) {
                record.put(rsmd.getColumnLabel(i), rs.getString(i));
            }
            results.put(String.valueOf(rId++), record);
        }
    } catch (final SQLException ex) {
        ex.printStackTrace(System.out);
    }

    return results;
}

public static void printMap(final Map<?, ?> mp) {
    for (final Entry<?, ?> entry : mp.entrySet()) {
        final Object key = entry.getKey();
        final Object value = entry.getValue();
        if (value instanceof Map) {
            System.out.println(key);
            printMap((Map<?, ?>) value);
        } else {
            System.out.println(key + "=" + entry.getValue());
        }
    }
}