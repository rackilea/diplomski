final int batchSize = 10000;
    int count = 0;
    Connection dbConnection = null;
    try {
        dbConnection = getDBConnection();
        String SQL = "INSERT INTO masterdict (window) " +
                 "VALUES(?)";

        PreparedStatement ps = (PreparedStatement) dbConnection.prepareStatement(SQL);
        dbConnection.setAutoCommit(false);
        for (String k : masterDict.keySet()) {
            ps.setString(1,k);
            ps.addBatch();
            if(++count % batchSize == 0) {
                System.out.println(count);
                ps.executeBatch();
                dbConnection.commit();
            }
        }
        ps.executeBatch();
        dbConnection.commit();
        ps.close();

    } catch (SQLException e) {
        if (dbConnection != null) {
            dbConnection.rollback();
        }
        System.out.println(e.getMessage());

    } finally {
        dbConnection.close();
    }