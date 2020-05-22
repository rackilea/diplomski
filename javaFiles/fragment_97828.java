public static void toFlat(Connection conn, File file, String destcode) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    BufferedWriter out = null;
    try {
        ps = conn.prepareStatement(
            // col#:   1         2         3           4
            "SELECT threatid, lastname, firstname, flightnum " +
            "FROM travel.passengers " +
            "JOIN threats.aliases USING (firstname, lastname) " +
            "WHERE destination = ?" // param# 1
        );
        ps.setString(1,destcode); // param# 1

        out = new BufferedWriter(new FileWriter(file));


        // provides hint for driver to load x rows at a time:
        ps.setFetchSize(1000); 
        ps.executeQuery();
        rs = ps.getResultSet();

        while(rs.next()) {
            Integer threatid = rs.getInt(1);
            String lastname = rs.getString(2);
            String firstname = rs.getString(3);
            Integer flightnum = rs.getInt(4);

            //rubber meets road:
            String row = processRow(threatid, lastname, firstname, flightnum);
            out.write(row);
        }
    } catch(SQLException e) {
        // TODO
    } catch (IOException e) {
        // TODO
        e.printStackTrace();
    } finally {
        try {
            ps.close();
        } catch(Exception e){
            //TODO
        }
        try {
            rs.close();
        } catch(Exception e){
            //TODO
        }
        try {
            out.close();
        } catch(Exception e){
            //TODO
        }
    }
}