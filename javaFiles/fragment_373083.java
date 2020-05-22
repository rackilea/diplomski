public boolean update2(String dto) {
    assert dto != null;

    if (readById(dto.getId()).getId() == 0) {
        throw new RuntimeException("Row with this id doesn't exist");
    }

    boolean flag = false;
    String sql = "SQL statement";
    try (Connection connection = DAOFactory.createConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.executeUpdate();
        flag = true;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return flag;
}