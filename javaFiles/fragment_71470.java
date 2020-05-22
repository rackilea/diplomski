boolean update(String sql, StatementPreparer sp) {
    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
        sp.prepare(preparedStatement);
        preparedStatement.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}