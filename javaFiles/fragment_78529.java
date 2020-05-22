@Override
public void save(Planet planet) throws SQLException {
    String namePlanet = planet.getName();
    float massPlanet = planet.getMass();
    boolean habitablePlanet = planet.isHabitable();
    sql = "INSERT INTO planeta (nom,massa,habitable) VALUES (?,?,?)";
    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setString(1, namePlanet);
    preparedStatement.setFloat(2, massPlanet);
    preparedStatement.setBoolean(3, habitablePlanet);
    preparedStatement.executeUpdate(); // <--- Here was the error!!