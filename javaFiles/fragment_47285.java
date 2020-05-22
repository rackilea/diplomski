public String[] getChartTime() throws SQLException
{
    // ...
    // Earlier lines as before, let's start from the variable
    final List<String> timeStr = new ArrayList<>();
    while(rs.next()) {
        // Just get the value of the column, and add it to the list
        timeStr.add(rs.getString("logtime"));
    }

    // I would return the list here, but let's convert it to an array
    return timeStr.toArray(new String[timeStr.size()]);
}