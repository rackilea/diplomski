public void insertWordPairIntoTable(String englishVoc, String germanTranslation) {
    try (PreparedStatement insert = connection.prepareStatement(
            "insert into vocabulary values(?,?)")) {
        insert.setString(1, englishVoc);
        insert.setString(2, germanTranslation);

        insert.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Cannot insert word pair into SQL Database.", e);
    }
}