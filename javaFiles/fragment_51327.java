public  void displayRecords(String[] catids) {
    try {
        String queryStart = "select id from quest where quest_id in ( ";
        String queryMiddle = "";
        String prefix = "";
        String queryEnd = " )";
        String query = "";

        if (catids != null && catids.length > 0) {
            for (String id : catids) {
                queryMiddle = queryMiddle + prefix + "?";
                prefix = ",";
            }
            query = queryStart + queryMiddle + queryEnd;
            System.out.println(query);
            Class.forName(....);
            Connection conn = DriverManager.getConnection(....);
            PreparedStatement stmt = conn.createPreparedStatement(query);
            int i = 1;
            for (String id : catids) {
                stmt.setInt(i++, Integer.parseInt(id));
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int fragenid = rs.getInt("id");
                System.out.println("ID = " + fragenid);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}