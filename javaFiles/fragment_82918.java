public int addArtist(String name) throws SQLException {
    int artist_id;

    try (CallableStatement callableStatement = 
            connection.prepareCall("{ ? = CALL add_artist(?::citext) }")) {
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.setString(2, name);
        callableStatement.execute();
        artist_id = callableStatement.getInt(1);
    }

    return (artist_id != 0) ? artist_id : -1;
}