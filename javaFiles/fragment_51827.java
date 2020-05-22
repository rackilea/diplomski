while (rs.next()) {
    double sum = 0;
    int count = 0;

    if (!"OFF".equals(rs.getString(7))) {
        sum += rs.getDouble(7);
        count += 1;
    }

    if (!"OFF".equals(rs.getString(8))) {
        sum += rs.getDouble(8);
        count += 1;
    }

    if (!"OFF".equals(rs.getString(10))) {
        sum += rs.getDouble(10);
        count += 1;
    }

    double average;
    if (count > 0)
        average = sum / count;
    else
        average = 0; // or whatever the result of all OFF means

    averageMap3.put(rs.getString(1), average);
}