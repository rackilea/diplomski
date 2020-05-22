List<Player> players = getData(Player.class);
List<Student> students = getData(Student.class);

public List<T> getData(Class<T> clazz) {

    String sql = "SELECT * FROM " + clazz.getSimpleName();
    List<T> lstPlayers  = getJdbcTemplate().query(
            sql,
            new BeanPropertyRowMapper(clazz));

    return lstPlayers;
}