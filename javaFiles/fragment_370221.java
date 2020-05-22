public void DBInsert(String query, Connection conn) {
    try (Statement stm = conn.createStatement()){
        stm.executeUpdate(query);
        conn.commit();
    } catch (SQLException ex) {
        ex.getLocalizedMessage();
    } finally {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}