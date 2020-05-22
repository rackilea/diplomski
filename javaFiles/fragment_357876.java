public class PassportRowMapper implements RowMapper<Passport> {

    public Passport mapRow(ResultSet rs, int rowNum) throws SQLException {
        Passport p = new Passport();
        p.setNumber(rs.getString(1));
        // further logic to get row information
        return p;
    }
}