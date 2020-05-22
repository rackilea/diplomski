String[] datesToApply = new String[] 
        {
        "1978-12-31",
        "junk",
        "1981-11-11"
        };

String sql = 
        "UPDATE Clients SET DOB=? WHERE ID=1";
try (PreparedStatement ps = conn.prepareStatement(sql)) {
    for (String dt : datesToApply) {
        ps.setString(1, dt);
        ps.addBatch();
    }
    int[] updateCounts = null;
    try {
        updateCounts = ps.executeBatch();
    } catch (BatchUpdateException bue) {
        System.out.println("executeBatch threw BatchUpdateException: " + bue.getMessage());
        updateCounts = bue.getUpdateCounts();
    } catch (SQLException se) {
        System.out.println("executeBatch threw SQLException: " + se.getMessage());
    }
    if (updateCounts != null) {
        for (int uc : updateCounts) {
            System.out.println(uc);
        }
    }
    if (!conn.getAutoCommit()) {
        conn.commit();
    }