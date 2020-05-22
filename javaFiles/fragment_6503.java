PreparedStatement stmt = getSql().prepareStatement(...);
    try {
        for (Row row: rows) {
            stmt.setLong(1, row.id);
            ...
            stmt.addBatch();
        }
        stmt.executeBatch();
    } finally {
        stmt.close();
    }