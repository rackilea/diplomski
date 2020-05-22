try {
    String path = selectedFiles;
    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + path + ";jackcessOpener=app.test.CryptCodecOpener", "", "");
    Statement s = conn.createStatement();
    ResultSet rs = s.executeQuery("SELECT TIMESTAMPDIFF(year,vis.VisitDate,vis.DateOfBirth) as date_diff "
            + " FROM tblExportHTC vis WHERE vis.ClientCode='PITC-TENT-4-093'");
    while (rs.next()) {
        int visits_count = rs.getInt("date_diff");
        System.err.println("index_pos_from_sexual_partners: " + visits_count);
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}