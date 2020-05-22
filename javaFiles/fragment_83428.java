public List<UsuariousGrupos> select(Integer idGrupo) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<UsuariousGrupos> usuariousGrupos = new ArrayList<UsariousGrupos>();

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement("select id_usuario, id_grupo from usuarios_grupos where id_grupo = ?");
        statement.setInt(1, idGrupo);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            usuariousGrupos.add(mapUsuariousGrupos(resultSet));
        }
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}

    }

    return usuariousGrupos;
}