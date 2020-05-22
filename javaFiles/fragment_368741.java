public static void convertToCSV(final ResultSet rs) throws SQLException, IOException {
    final BufferedWriter fw = new BufferedWriter(new FileWriter(new File("alert.csv")));
    final DateFormat format = new SimpleDateFormat("'yyyyMMdd','HH:mm:ss'");
    format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

    while (rs.next()) {
      StringBuilder sb = new StringBuilder();
      sb.append(rs.getString("FIELD1")).append(',')
        .append(rs.getString("FIELD2")).append(',')
        .append(rs.getString("FIELD3")).append(',');

        final String clobValue = rs.getString("FIELD4");
        if(clobValue==null)
          sb.append("null,");            
        else{
          sb.append('\"').append(clobValue).append('\"').append(',');
        }
        Date date = new Date(rs.getLong("FIELD5"));
        sb.append(format.format(date)).append('\n');
        fw.write(sb.toString());
    }
    fw.close();
}