while (rs.next()) {
    double sum = 0;
    int count = 0;
    for (int column : new int[] { 7, 8, 10 }) {
        if (!"OFF".equals(rs.getString(column))) {
            sum += rs.getDouble(column);
            count += 1;
        }
    }
    double average = count > 0 ? sum / count : 0;
    averageMap3.put(rs.getString(1), average);
}