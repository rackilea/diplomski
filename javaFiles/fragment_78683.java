connectionUrl = "jdbc:mysql://localhost:3307/mydb";
try (Connection conn = DriverManager.getConnection(connectionUrl, myUid, myPwd)) {
    SimpleDateFormat sdfLocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    Calendar calUTC = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    SimpleDateFormat sdfUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    sdfUTC.setCalendar(calUTC);
    String sql = 
            "SELECT id, CAST(dateTime AS CHAR) AS datetimeString, dateTime " + 
            "FROM tztest ORDER BY dateTime";
    try (   Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            int id = rs.getInt("id");
            String datetimeString = rs.getString("datetimeString");
            Timestamp timestampValue = rs.getTimestamp("dateTime", calUTC);
            long minutesSinceEpoch = timestampValue.getTime() / 60000;
            System.out.printf("%d: %s -> %d minutes since epoch -> %s / %s%n",
                    id,
                    datetimeString, 
                    minutesSinceEpoch,
                    sdfLocal.format(timestampValue),
                    sdfUTC.format(timestampValue)
                    );
        }
    }
} catch (Exception e) {
    e.printStackTrace(System.err);
}